# Atividade CRUD (Problemática)

#### localhost:8080

## Personagem
- Cada personagem possui 10 pontos para distribuir entre **força** e **defesa**.
- Pode ter **apenas um amuleto**.
- Classes: `GUERREIRO`, `MAGO`, `ARQUEIRO`, `LADINO`, `BARDO`.
- Atributos exibidos devem somar os valores dos itens mágicos equipados.

## Item Mágico
- Tipos permitidos: `ARMA`, `ARMADURA`, `AMULETO`.
- Armas: **defesa = 0** obrigatoriamente.
- Armaduras: **força = 0** obrigatoriamente.
- Amuletos: podem ter ambos os atributos, mas **só um por personagem**.
- Força e Defesa vão de **1 a 10**. Não pode ser 0 em ambos.

---

## Endpoints

### Personagens

#### Criar Personagem
- **POST** `/personagens`

#### Listar Personagens
- **GET** `/personagens`

#### Buscar Personagem por ID
- **GET** `/personagens/{id}`

#### Remover Personagem
- **DELETE** `/personagens/{id}`

#### Atualizar nome do personagem
- **PUT** `/personagens/{id}/nome`

#### Atualizar nome do aventureiro
- **PUT** `/personagens/{id}/nome-aventureiro`


### Itens Mágicos

#### Criar Item Mágico
- **POST** `/itens`

#### Listar Itens
- **GET** `/itens`

#### Buscar Item por ID
- **GET** `/itens/{id}`


### Itens por Personagem

#### Adicionar item ao personagem
- **POST** `/personagens/{idPersonagem}/itens/{idItem}`

#### Remover item do personagem
- **DELETE** `/personagens/{idPersonagem}/itens/{idItem}`

#### Listar itens do personagem
- **GET** `/personagens/{id}/itens`

#### Listar amuleto do personagem
- **GET** `/personagens/{id}/amuleto`
