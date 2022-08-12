# PadraoMutex
Trabalho sobre programacao paralela no java:

### QUESTAO PROPOSTA

Exercício de aplicação do Padrão Mutex 
 
Implemente dois tipos de threads, denominadas GeradorPares e GeradorImpares, que 
compartilham um array com capacidade para armazenar 100 valores inteiros, 
denominado CHAVE, e executam em paralelo, com as seguintes definições: 
 
GeradorPares: 
 
- Enquanto há espaço disponível no array CHAVE: 
  1. Dorme por um tempo aleatório entre 1000 e 3000 milisegundos 
  2. Gera um número par aleatório n entre 0 e 8 
  3. Insere o número n no array CHAVE 
  4. Incrementa o contador de pares 
 
GeradorImpares: 
 
- Enquanto há espaço disponível no array CHAVE: 
  1. Dorme por um tempo aleatório entre 1000 e 3000 milisegundos 
  2. Gera um número ímpar aleatório n entre 1 e 9 
  3. Insere o número n no array CHAVE 
  4. Incrementa o contador de ímpares 
 
 
Importante: <br />
- Devem ser criadas duas instâncias de cada tipo de thread, além da thread inicial (main). Logo, haverá um total de cinco threads em execução. <br />
- O array CHAVE deve ser alocado em memória com tamanho fixo, antes do início das threads e não pode ser usada nenhuma classe de biblioteca da linguagem de programação. Em Java, deve ser criado da seguinte forma: int[] CHAVE = new int[100]; <br />
- O array CHAVE deve estar vazio quando as threads são iniciadas. <br />
- O array CHAVE deve ser preenchido pelas threads sequencialmente, da primeira até a última posição. <br /> 
- Os contadores de pares e de ímpares têm o valor 0 quando as threads são iniciadas. <br />
- Depois que o array CHAVE estiver totalmente preenchido, deve ser impresso, e também devem ser impressos os contadores de pares e de ímpares. <br />
