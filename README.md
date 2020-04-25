# Berkeley

Implementação do algoritmo de Berkeley, Client-Server Architecture (Java RMI), para a matéria Sistemas Distribuídos na FURB.

Autores
> [Eduardo Z. Feller](https://github.com/eduardofz12) <br>
> [Hugo Marcel Larsen](https://github.com/HMLarsen) <br>
> [Lucas Vanderlinde](https://github.com/LucasVander) <br>

### Execução

```
maven clean install
```

Iniciar os servidores de cada uma das três máquinas com seus horários locais.

```
java -cp target/t3-berkeley-1.0.0.jar server.machine.Machine1
java -cp target/t3-berkeley-1.0.0.jar server.machine.Machine2
java -cp target/t3-berkeley-1.0.0.jar server.machine.Machine3
```

Executar a classe principal do algoritmo e verificar a mudança nos horários das três máquinas.

```
java -jar target/t3-berkeley-1.0.0.jar
```
