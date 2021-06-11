//jogos
function adicionarJogo() {
    let jogo = {
        timeA: document.getElementById('timeA').value,
        timeB: document.getElementById('timeB').value,
        golsA: document.getElementById('golsA').value,
        golsB: document.getElementById('golsB').value
    }
    if((document.getElementById('timeA').value == "") || (document.getElementById('timeB').value == "")|| 
        (document.getElementById('golsA').value == "") || (document.getElementById('golsB').value == "")){
        alert("Preencha os campos vazios")
    }else{
        createJogo(jogo, function(status, dados){
            if(status < 200 || status > 299 ) {
                alert("Verifique se os campos estão preenchidos corretamente");
            }else{
                window.location.reload()
            }
            
        })
    }   
}

function mostrarJogos() {
    getJogos(function (status, dados) {
        if(status < 200 || status > 299 ) {
            alert('Erro ao carregar os dados');
        }

        document.getElementById("jogos").innerHTML = "";
        for(let i=0; i<dados.length; i++) {
            let jogo = dados[i];
            document.getElementById("jogos").innerHTML += 
            `
            <tr>
            <td>${jogo.id}</td>
            <td>${jogo.timeA}</td>
            <td>${jogo.timeB}</td>
            <td><button onclick=\"atualizarFormJogo(${jogo.id})\" class=\"btn btn-primary\" 
            data-bs-toggle=\"modal\" data-bs-target=\"#editJogoModal\">Editar</button>
            <button onclick=\"apagarJogo(${jogo.id})\" class=\"btn btn-danger\">Apagar</button></td>
            </tr>
            ` 
        }
    })
}

function obterJogosByTimeA(){
    var nomeTimeA = document.getElementById('pesquisaJogo').value
    getJogoByTimeA(nomeTimeA, function(status, dados){
        if(status < 200 || status > 299 ) {
            alert('Erro ao carregar os dados');
        }

        document.getElementById("buscaJogos").innerHTML = "";
        for(var i=0; i<dados.length; i++) {
            var jogo = dados[i];
            document.getElementById("buscaJogos").innerHTML += `
            <div">
            <p><b>ID: </b>${jogo.id}</p>
            <p><b>Time A: </b>${jogo.timeA}</p>
            <p><b>Time B: </b>${jogo.timeB}</p>
            <p><b>Gols A: </b>${jogo.golsA}</p>
            <p><b>Gols B: </b>${jogo.golsB}</p>
            </div>
            <hr/>
            `    
        }
    })
}

function atualizarFormJogo(id) {
    getJogoById(id, function (status, dados) {
        document.getElementById('idJogo').value = dados.id
        document.getElementById('timeAUpdate').value = dados.timeA
        document.getElementById('timeBUpdate').value = dados.timeB
        document.getElementById('golsAUpdate').value = dados.golsA
        document.getElementById('golsBUpdate').value = dados.golsB  
    })
}

function atualizarJogo() {
    let jogo = {
        id: document.getElementById('idJogo').value,
        timeA: document.getElementById('timeAUpdate').value,
        timeB: document.getElementById('timeBUpdate').value,
        golsA: document.getElementById('golsAUpdate').value,
        golsB: document.getElementById('golsBUpdate').value
    }
    if((document.getElementById('timeAUpdate').value == "") || (document.getElementById('timeBUpdate').value == "")|| 
        (document.getElementById('golsAUpdate').value == "") || (document.getElementById('golsBUpdate').value == "")){
        alert("Preencha os campos vazios")
    }else{
        updateJogo(jogo, function(status, dados){
            if(status < 200 || status > 299 ) {
                alert('Não foi possíve alterar os dados do jogo');
            }else{
                window.location.reload()
            }
            
        })
        
    }
}

function apagarJogo(id) {
    if(confirm("Deseja apagar dados do jogo?")) {
        deleteJogo(id, function(status, dados) {
            if(status < 200 || status > 299 ) {
                alert("Erro ao apagar jogo");
                return;
            }else{
                window.location.reload()
            }
            
        })
    } else {
        alert('Ação de apagar foi cancelada');
    }
}


//cidades
function adicionarCidade() {
    let cidade = {
        nome: document.getElementById('nome').value,
        estado: document.getElementById('estado').value,
        pais: document.getElementById('pais').value,
        populacao: document.getElementById('populacao').value
    }
    if((document.getElementById('nome').value == "") || (document.getElementById('estado').value == "")|| 
        (document.getElementById('pais').value == "") || (document.getElementById('populacao').value == "")){
        alert("Preencha os campos vazios")
    }else{
        createCidade(cidade, function(status, dados){
            if(status < 200 || status > 299 ) {
                alert("Verifique se os campos estão preenchidos corretamente");
            }else{
                window.location.reload()
            }
                
        })
    }
}

function mostrarCidades() {
    getCidades(function (status, dados) {
        if(status < 200 || status > 299 ) {
            alert("Erro ao carregar dados");
        }

        document.getElementById("cidades").innerHTML = "";
        for(let i=0; i<dados.length; i++) {
            let cidade = dados[i];
            document.getElementById("cidades").innerHTML += 
            `
            <tr>
            <td>${cidade.id}</td>
            <td>${cidade.nome}</td>
            <td><button onclick=\"atualizarFormCidade(${cidade.id})\" class=\"btn btn-primary\" 
            data-bs-toggle=\"modal\" data-bs-target=\"#editCidadeModal\">Editar</button>
            <button onclick=\"apagarCidade(${cidade.id})\" class=\"btn btn-danger\">Apagar</button></td>
            </tr>
            `     
        }
    });
}

function obterCidadesByNome(){
    var nomeCidade = document.getElementById('pesquisaCidade').value
    getCidadeByNome(nomeCidade, function(status, dados){
        if(status < 200 || status > 299 ) {
            alert('Erro ao carregar os dados');
        }

        document.getElementById("buscaCidades").innerHTML = "";
        for(var i=0; i<dados.length; i++) {
            var cidade = dados[i];
            document.getElementById("buscaCidades").innerHTML += `
            <div">
            <p><b>ID: </b>${cidade.id}</p>
            <p><b>Nome: </b>${cidade.nome}</p>
            <p><b>Estado: </b>${cidade.estado}</p>
            <p><b>País: </b>${cidade.pais}</p>
            <p><b>População: </b>${cidade.populacao}</p>
            </div>
            <hr/>
            `    
        }
    })
}

function atualizarFormCidade(id) {
    getCidadeById(id, function (status, dados) {
        document.getElementById('idCidade').value = dados.id
        document.getElementById('nomeUpdate').value = dados.nome
        document.getElementById('estadoUpdate').value = dados.estado
        document.getElementById('paisUpdate').value = dados.pais
        document.getElementById('populacaoUpdate').value = dados.populacao 
    })
}

function atualizarCidade() {
    let cidade = {
        id: document.getElementById('idCidade').value,
        nome: document.getElementById('nomeUpdate').value,
        estado: document.getElementById('estadoUpdate').value,
        pais: document.getElementById('paisUpdate').value,
        populacao: document.getElementById('populacaoUpdate').value
    }
    if((document.getElementById('nomeUpdate').value == "") || (document.getElementById('estadoUpdate').value == "")|| 
        (document.getElementById('paisUpdate').value == "") || (document.getElementById('populacaoUpdate').value == "")){
        alert("Preencha os campos vazios")
    }else{
        updateCidade(cidade, function(status, dados){
            if(status < 200 || status > 299 ) {
                alert('Não foi possível alterar os dados da cidade');
            }else{
                window.location.reload()
            }
              
        })
    }
}

function apagarCidade(id) {
    if(confirm("Deseja apagar dados da cidade?")) {
        deleteCidade(id, function(status, dados) {
            if(status < 200 || status > 299 ) {
                alert("Erro ao apagar cidade");
                return;
            }else{
                window.location.reload()
            }   
        })
    }else{
        alert('Ação de apagar foi cancelada');
    }
}

        