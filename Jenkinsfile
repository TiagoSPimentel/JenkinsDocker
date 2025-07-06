pipeline {
    agent none // necessário quando você usa `agent` em cada stage

    stages {
        stage('Build em Container') {
            agent {
                docker {
                    image 'openjdk:17'
                    args '-v $WORKSPACE:/app -w /app'
                }
            }
            steps {
                sh '''
                    echo "Compilando código-fonte..."
                    javac src/main/java/ConversorTemperatura.java
                '''
            }
        }

        stage('Testes em Container') {
            agent {
                docker {
                    image 'openjdk:17'
                    args '-v $WORKSPACE:/app -w /app'
                }
            }
            steps {
                sh '''
                    echo "Baixando dependências JUnit..."
                    mkdir -p libs
                    curl -L -o libs/junit-4.13.2.jar https://search.maven.org/remotecontent?filepath=junit/junit/4.13.2/junit-4.13.2.jar
                    curl -L -o libs/hamcrest-core-1.3.jar https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar

                    echo "Compilando testes..."
                    javac -cp libs/* src/test/java/ConversorTemperaturaTest.java

                    echo "Executando testes..."
                    java -cp libs/*:src/test/java:src/main/java org.junit.runner.JUnitCore ConversorTemperaturaTest
                '''
            }
        }
    }
}
