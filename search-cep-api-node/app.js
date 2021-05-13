const express = require('express')
const fetch = require("node-fetch");

const app = express()

app.use(express.json());

app.get('/', (req, res) => {
  res.send('<H1>Search Cep APP on air!</H1>')
})

app.get('/api/search-cep/:cep', (req, res) => {
  const cep = req.params.cep
  
  console.log(cep)
  
  const options = {
      method: "GET",
      mode: "cors",
      cache: "default"
  }

  fetch(`https://viacep.com.br/ws/${cep}/json/`, options)
      .then(response => {
          response.json()
              .then(data => {
                res.json(data)
              })
      })
      .catch(e => console.log(e))
})

module.exports = app;