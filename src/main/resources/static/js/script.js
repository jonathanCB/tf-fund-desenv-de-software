// Consulta os dados do aluno
async function salvarevento(nomeEvento, diaSemana,
    qtdPessoas, descontoPromo) {
    //console.log(matricula);

    let url = "http://localhost:8080/detalhesevento/persiste";
    url = url + "?nomeEvento=" + nomeEvento;
    url = url + "&diaSemana=" + diaSemana;
    url = url + "&qtdPessoas=" + qtdPessoas;
    url = url + "&descontoPromo=" + descontoPromo;

    try {
        let resposta = await fetch(url);
        //console.log(resposta);
        if (resposta.ok) {
            let dados = await resposta.json();
            //console.log(dados);
            return dados;
        } else {
            //console.log(resposta.status+", text="+resposta.statusText);
            return null;
        }
    } catch (erro) {
        console.log(erro);
    }
}

// Consulta aprovação do aluno
async function consultaAprovacao(matricula) {
    let url = "http://localhost:8080/consulta_aluno/aprovacao";
    url = url + "?matricula=" + matricula;

    try {
        let resposta = await fetch(url);
        console.log(resposta);
        if (resposta.ok) {
            let dados = await resposta.json();
            console.log(dados);
            return dados;
        } else {
            console.log(resposta.status + ", text=" + resposta.statusText);
            return null;
        }
    } catch (erro) {
        console.log(erro);
    }
}

// --- início do programa
document.getElementById("submit").onclick = async function () {
    nomeEvento = document.getElementById("nomeEventoValor").value;
    diaSemana = document.getElementById("diaDaSemanaValor").value;
    qtdPessoas = document.getElementById("qtdPessoasValor").value;
    descontoPromo = document.getElementById("descontoPromocionalValor").value;
    let resposta = await salvarevento(nomeEvento, diaSemana, qtdPessoas, descontoPromo);
    if (resposta != null) {
        let nome = document.getElementById("codEventoValor");
        nome.innerHTML = resposta.nome;
        let g1 = document.getElementById("g1Valor");
        g1.innerHTML = resposta.grauG1;
        let g2 = document.getElementById("g2Valor");
        g2.innerHTML = resposta.grauG2;
        erro = document.getElementById("erro");
        erro.innerHTML = "";
        //let json = document.getElementById("jsonValor");
        //json.innerHTML = JSON.stringify(resposta);
    } else {
        let nome = document.getElementById("nomeValor");
        nome.innerHTML = " - ";
        let g1 = document.getElementById("g1Valor");
        g1.innerHTML = " - ";
        let g2 = document.getElementById("g2Valor");
        g2.innerHTML = " - ";
        erro = document.getElementById("erro");
        erro.innerHTML = "Erro na consulta dos dados";
    }

    document.getElementById("btAprovacao").onclick = async function () {
        matricula = document.getElementById("matricula").value;
        let resposta = await consultaAprovacao(matricula);
        if (resposta != null) {
            let aprovacao = document.getElementById("aprovacao");
            if (resposta == true) {
                aprovacao.innerHTML = "Aluno matricula: " + matricula + ", APROVADO";
            } else {
                aprovacao.innerHTML = "Aluno matricula: " + matricula + ", REPROVADO";
            }
            erro = document.getElementById("erro");
            erro.innerHTML = " - ";
        } else {
            erro = document.getElementById("erro");
            erro.innerHTML = "Erro na consulta da aprovacao";
        }
    }
}

