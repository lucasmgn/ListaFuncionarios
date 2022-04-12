# ListaFuncionarios

<h2> Como funciona?</h2>

<p> A aplicação <strong>Lista de Funcionários</strong> funciona como uma ponte entre o código e o banco de dados, basicamente o usuário pode cadastrar, remover e verificar um lista de funcionários criada pelo mesmo e salva no banco de dados, utilizei o JDBC e o banco de dados MySql para isso.</p>
  
  <h3>Passo a passo</h3>
  
<p> Criei uma classe modelo chamada Funcionario e coloquei seus atributos: </p>
    <ul>
      <li>private String nome;</li>
      <li>private int listagem;</li>
      <li>private String dataNascimento;</li>
      <li>private String cargo;</li>
    </ul>
    
<p>Uma classe chamada <strong>Main</strong> para eu excecutar o código, essa classe possui um swich com as opções de metódos <strong> cadastrandoFuncionario, removendoFuncionario, mostrandoLista</strong> metódos esses que o usuário escolhe o que quer fazer.</p>
<br>
<h3>Início do Console:</h3>

![Captura de Tela (45)](https://user-images.githubusercontent.com/81782608/163070215-c944fa27-5f7f-43f8-bb68-fd52eea76ca3.png)
<br>
<br>
<h3>Cadastrando um funcionário:</h3>
  
 ![Captura de Tela (47)](https://user-images.githubusercontent.com/81782608/163070693-760daf27-bec5-416d-b51f-73a90f23c334.png)
<br>
<br>
<h3>Removendo um funcionário:</h3>
<br>
<h4>BD antes da remoção:</h4>

![Captura de Tela (49)](https://user-images.githubusercontent.com/81782608/163071306-30571b3c-97f3-4f38-b78d-aad1a25aac1d.png)
<br>
<br>
<h4>Console de remoção:</h4>

![Captura de Tela (50)](https://user-images.githubusercontent.com/81782608/163071557-6758d072-68d3-4e99-8ad3-0cf69fce9ff4.png)
<br>
<br>
<h4>BD depois da remoção:</h4>

![Captura de Tela (51)](https://user-images.githubusercontent.com/81782608/163072123-7723e8ff-e044-4a0b-958f-68e1620ce5af.png)
<br>
<br>
<h3>Vendo Lista de Funcionários cadastrados no BD:</h3>

![Captura de Tela (52)](https://user-images.githubusercontent.com/81782608/163072586-a9bdb8f8-a289-4f6a-8c86-11f519682ffc.png)
<br>
<br>
<h3>Encerrando a Aplicação</h3>

![Captura de Tela (53)](https://user-images.githubusercontent.com/81782608/163072844-8a32aec8-81e2-4110-aa90-5b1caa0803c1.png)

