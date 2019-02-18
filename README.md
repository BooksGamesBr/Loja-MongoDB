# Loja-MongoDB # Importar csv
 mongoimport -d loja -c cor --type csv --headerline --file dir/cor.csv

# Baixando o mongo
docker pull mongo:"4.0.4"
# Rodando no Docker o mongo
docker run --name mongo-springboot -p 27017:27017 -d mongo
#Verificando
docker ps -a
#Executando o Docker
docker exec -it mongo-springboot mongo admin
#Parando
docker stop mongo-springboot

#Criar
docker run --name zaaldb -e POSTGRES_PASSWORD=debian23 -d postgres
#Executar
docker exec -it zaaldb psql -U postgres
#Automatico
docker run --name zaaldb -v "$PWD"/:/opt/zaaldb/ -e POSTGRES_PASSWORD=debian23
-d postgres