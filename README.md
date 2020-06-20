# Berkeley-Algorithm

Berkeley algorithm implementation, using Client-Server Architecture (Java RMI), for Distributed Systems class at FURB.

Authors
> [Eduardo Z. Feller](https://github.com/eduardofz12) <br>
> [Hugo Marcel Larsen](https://github.com/HMLarsen) <br>
> [Lucas Vanderlinde](https://github.com/LucasVander) <br>

### Execution

```
maven clean install
```

Start the servers on each of the three machines with their local time.

```
java --enable-preview -cp target/t3-berkeley-1.0.0.jar server.machine.Machine1
java --enable-preview -cp target/t3-berkeley-1.0.0.jar server.machine.Machine2
java --enable-preview -cp target/t3-berkeley-1.0.0.jar server.machine.Machine3
```

Run the main class of the algorithm and check the change in the local time of the three machines.

```
java --enable-preview -jar target/t3-berkeley-1.0.0.jar
```
