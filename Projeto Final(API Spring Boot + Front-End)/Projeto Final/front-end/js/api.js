const BASE_URL = "http://localhost:8080";

//jogos
function createJogo(jogo, callback) {
    var url = BASE_URL + '/api/jogos';
    var xhr = new XMLHttpRequest();
    dados = JSON.stringify(jogo);
    xhr.open('POST', url, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send(dados);
}

function getJogos(callback) {
    var url = BASE_URL + '/api/jogos';
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send();
}

function getJogoById(id, callback) {
    var url = BASE_URL + '/api/jogos/' + id;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send();
}

function getJogoByTimeA(nomeTimeA, callback) {
    var url = BASE_URL + '/api/jogos/filter?timea=' +nomeTimeA;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send();
}

function updateJogo(jogo, callback) {
    var url = BASE_URL + '/api/jogos/' + jogo.id;
    var xhr = new XMLHttpRequest();
    dados = JSON.stringify(jogo);
    xhr.open('PUT', url, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send(dados);
}

function deleteJogo(id, callback) {
    var url = BASE_URL + '/api/jogos/' + id;
    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send();
}

//cidades
function createCidade(cidade, callback) {
    var url = BASE_URL + '/api/cidades';
    var xhr = new XMLHttpRequest();
    dados = JSON.stringify(cidade);
    xhr.open('POST', url, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send(dados);
}

function getCidades(callback) {
    var url = BASE_URL + '/api/cidades';
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send();
}

function getCidadeById(id, callback) {
    var url = BASE_URL + '/api/cidades/' + id;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send();
}

function getCidadeByNome(nomeCidade, callback) {
    var url = BASE_URL + '/api/cidades/filter?nome=' +nomeCidade;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send();
}

function updateCidade(cidade, callback) {
    var url = BASE_URL + '/api/cidades/' + cidade.id;
    var xhr = new XMLHttpRequest();
    dados = JSON.stringify(cidade);
    xhr.open('PUT', url, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send(dados);
}

function deleteCidade(id, callback) {
    var url = BASE_URL + '/api/cidades/' + id;
    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', url, true);
    xhr.responseType = 'json';
    xhr.onload = function () {
        callback(xhr.status, xhr.response);
    }
    xhr.send();
}