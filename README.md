# treinamentoFullStack

Get_Veiculo
localhost:8080/veiculos/jkl1235

Post_Veiculo
http://localhost:8080/veiculos
{
  "placa": "jkl1235",
  "renavam": "987654321",
  "cpfCnpjProprietario": "12345678900"
}

Put_Veiculo
http://localhost:8080/veiculos/jkl1235
{
  "renavam": "333333333",
  "cpfCnpjProprietario": "88888888800"
}

Delete_Veiculo
http://localhost:8080/veiculos/jkl1235

----------------------------------------------------------

Get_Proprietario
http://localhost:8080/proprietarios/88888888800

Post_ Proprietario
http://localhost:8080/proprietarios
{
  "nome": "Pedro",
  "cpfCnpj": "88888888800",
  "endereco": "Rua c, 123"
}

Put_ Proprietario
http://localhost:8080/proprietarios/12345678900
{
  "nome": "João Silva",
  "endereco": "Rua B, 456"
}

Delete_ Proprietario
http://localhost:8080/proprietarios/88888888800
