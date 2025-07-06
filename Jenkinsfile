pipeline {
    agent none

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
                    javac -cp "libs/junit-4.13.2.jar:libs/hamcrest-core-1.3.jar:src/main/java" src/test/java/ConversorTemperaturaTest.java

                    echo "Executando testes..."
                    java -cp "libs/*:src/main/java:src/test/java" org.junit.runner.JUnitCore ConversorTemperaturaTest
                '''
            }
        }
    }
}
