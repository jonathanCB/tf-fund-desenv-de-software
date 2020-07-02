<<<<<<< HEAD
function getURLPadrao() {
    return "http://localhost:8080/detalhesevento";
}

async function salvarEvento() {
    nomeEvento = document.getElementById("nomeEvento").value;
    diaSemana = document.getElementById("diaSemana").value;
    qtdPessoas = document.getElementById("qtdPessoas").value;
    descPromocional = document.getElementById("descPromocional").value;

    let url = getURLPadrao();
    url += "/persiste";
    url += "?nomeEvento=" + nomeEvento;
    url += "&qtdPessoas=" + qtdPessoas;
    url += "&diaSemana=" + diaSemana;
    url += "&descPromocional=" + descPromocional;

    console.log(url);

    try {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", url, false);
        xhttp.send();//A execução do script para aqui até a requisição retornar do servidor

        const json = xhttp.responseText;
        const obj = JSON.parse(json);

        if (parseInt(obj.codigo) > 0) {
            alert("Evento salvo com sucesso :D Codigo = " + obj.codigo);
        }
        else {
            alert("Aconteceu algum erro ao salvar o Evento, por favor, tente novamente");
        }
=======
async function salvarEvento(nomeEvento, diaSemana,
    qtdPessoas, descPromocional) {
    let url = "http://localhost:8080/detalhesevento/persiste";
    url = url + "?nomeEvento=" + nomeEvento;
    url = url + "&qtdPessoas=" + qtdPessoas;
    url = url + "&diaSemana=" + diaSemana;
    url = url + "&descPromocional=" + descPromocional;

    //let url = "http://localhost:8080/detalhesevento/persiste?nomeEvento=Formatura&qtdPessoas=255&diaSemana=Quarta&descPromocional=sim";
    console.log(url);

    try {
        let resposta = await fetch(url);
        return resposta;
>>>>>>> 637be05348a70d1e7c99b3b8941d652a326bd01c
    } catch (erro) {
        console.log(erro);
        alert("Aconteceu algum erro ao salvar o Evento, por favor, tente novamente");
    }
}

<<<<<<< HEAD
async function PesquisarEvento() {
    idEvento = document.getElementById("idEvento").value;

    console.log(idEvento);

    let url = getURLPadrao();
    url += "/dadosevento";
    url += "?codigo=" + idEvento;

    try {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", url, false);
        xhttp.send();

        const json = xhttp.responseText;
        const obj = JSON.parse(json);
        console.log(obj.codigo);
        console.log(parseInt(obj.codigo));

        if (parseInt(obj.codigo) > 0) {
            codigo.textContent = obj.codigo
            nome.textContent = obj.nomeEvento
            qtdpessoas.textContent = obj.qtdPessoas
            diasemana.textContent = obj.diaDaSemana
            descontopromocional.textContent = obj.descontoPromocional
            desconto.textContent = obj.desconto
            valorpelodiasemana.textContent = obj.valoresPorDiaDaSemana
            valorporqtdpessoas.textContent = obj.valoresPorQtdDePessoas
            custototalevento.textContent = obj.custoDoEvento
        }
        else {
            alert("Código do evento inválido :C");
        }
    } catch (erro) {
        console.log(erro);
    }

}
=======
document.getElementById("btnSalvar").onclick = async function () {
    nomeEvento = document.getElementById("nomeEvento").value;
    diaSemana = document.getElementById("diaSemana").value;
    qtdPessoas = document.getElementById("qtdPessoas").value;
    descPromocional = document.getElementById("descontoPromocional").value;

    console.log(nomeEvento);
    console.log(diaSemana);
    console.log(qtdPessoas);
    console.log(descPromocional);

    let resposta = await salvarEvento(nomeEvento, diaSemana, qtdPessoas, descPromocional);
    console.log(resposta);

    if (resposta.ok) {
        return "Evento adicionado com sucesso";
    }
    return "Aconteceu um erro ao adicionar o evento";
}
>>>>>>> 637be05348a70d1e7c99b3b8941d652a326bd01c
