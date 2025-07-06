##Cenários:
Cenário 1: tudo certo
O código está correto e os testes passam.

Executar o job manualmente via botão Build Now no Jenkins.

Verificar que ambos os estágios (Build e Test) passaram com sucesso.

Cenário 2: deu ruim (compilação falha)
Simular erro no código-fonte. Exemplo: apagar um ; no final de uma linha em ConversorTemperatura.java.

Commitar e subir para o GitHub.

Rodar o job no Jenkins.

O estágio de build deve falhar.

Cenário 3: tá instável (teste falha)
Manter o build funcionando.

Alterar a lógica do método para retornar resultado incorreto de propósito.

Exemplo: return (f - 30) * 5 / 9;

Commitar e rodar no Jenkins.

O build passa, mas o estágio de teste falha (Jenkins mostra como unstable build).

Cenário 4: o lendário “nightly”
Criar agendamento no Jenkins:

Dentro do job, ir em Build Triggers > Build periodically

Usar cron H 1 * * * para rodar 1 vez por dia (ou simular com uma frequência menor só para testar)

Aguardar execução automática ou forçar horário.

Jenkins deve rodar automaticamente e mostrar histórico no dashboard.

medida usada: H/2 * * * *(2 minutos)
