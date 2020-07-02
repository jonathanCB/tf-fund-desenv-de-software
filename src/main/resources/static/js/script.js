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
    } catch (erro) {
        console.log(erro);
    }
}

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
