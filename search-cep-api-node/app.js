const express = require('express')
const axios = require('axios')

const app = express()

app.use(express.json());

app.get('/', (req, res) => {
  res.send('<H1>Search Cep APP on air!</H1>')
})

app.get('/api/search-cep/:cep', (req, res) => {
  const cep = req.params.cep
  
  console.log(cep)
  
  axios.get(`https://viacep.com.br/ws/${cep}/json`)
  .then(response => {
    console.log(response)
    res.json(response.data)
  })
  .catch(error => {
    console.log(error)
  });
})

module.exports = app;