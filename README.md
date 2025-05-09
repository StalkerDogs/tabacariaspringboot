# Sistema de Gerenciamento de Tabacaria

## 📋 Descrição
Este é um sistema de gerenciamento desenvolvido em Spring Boot para auxiliar na administração de tabacarias. O sistema oferece uma solução completa para controle de estoque, vendas, clientes e produtos relacionados ao segmento de tabacaria.

## 🚀 Funcionalidades Principais

### 1. Gestão de Produtos
- Cadastro de produtos (cigarros, charutos, acessórios, etc.)
- Controle de estoque
- Categorização de produtos
- Preços e margens de lucro

### 2. Gestão de Clientes
- Cadastro de clientes
- Histórico de compras
- Preferências de produtos


## 💻 Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (desenvolvimento)
- MySQL (produção)
- Maven
- Thymeleaf (templates)

## 🛠️ Configuração do Banco de Dados
O sistema utiliza Spring Data JPA para gerenciar automaticamente o banco de dados. Isso significa que:

1. As entidades são mapeadas automaticamente para tabelas
2. As relações entre tabelas são gerenciadas automaticamente
3. O banco de dados é criado e atualizado automaticamente baseado nas classes do projeto
4. Não é necessário criar manualmente tabelas ou estruturas

### Exemplo de Entidade
```java
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    // ... outros campos
}
```

## 🚀 Como Executar o Projeto

1. Clone o repositório
```bash
git clone [URL_DO_REPOSITÓRIO]
```

2. Configure o banco de dados em `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tabacaria
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. Execute o projeto
```bash
./mvnw spring-boot:run
```

## 📊 Benefícios para sua Tabacaria

1. **Organização**
   - Controle centralizado de todos os processos
   - Redução de erros humanos
   - Facilidade no gerenciamento de estoque

2. **Eficiência**
   - Agilidade nas vendas
   - Controle preciso de estoque
   - Relatórios em tempo real

3. **Gestão Financeira**
   - Previsão de compras
   - Histórico de compras

## 🤝 Contribuição
Contribuições são bem-vindas! Para contribuir:

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença
MIT License

Copyright (c) 2025 Samuel Arruda

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## 📧 Contato
Para suporte ou dúvidas, entre em contato através do email: [samuelredstar@myself.com] # tabacariaspringboot
