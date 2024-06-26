const formulario = document.querySelector("form");

const Inputnome = document.querySelector(".nome");
const Inputemail = document.querySelector(".email");
const Inputsenha = document.querySelector(".senha");
const Inputtelefone = document.querySelector(".telefone");

function cadastrar() {

    fetch("http://localhost:8080/usuarios",
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome: Inputnome.value,
                email: Inputemail.value,
                senha: Inputsenha.value,
                telefone: Inputtelefone.value
            })
        })
        .then(function (res) { console.log(res) })
        .catch(function (res) { console.log(res) })

};

function limpar() {

    Inputnome.value = "";
    Inputemail.value = "";
    Inputsenha.value = "";
    Inputtelefone.value = "";
    
};

formulario.addEventListener('submit', function (event) {

    event.preventDefault();

    cadastrar();
    limpar();

});

document.getElementById('listar-usuarios').addEventListener('click', listarUsuarios);

function listarUsuarios() {
    fetch("http://localhost:8080/usuarios", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "GET"
    })
    .then(response => response.json())
    .then(usuarios => {
        const usuariosLista = document.getElementById('usuarios-lista');
        usuariosLista.innerHTML = '';
        usuarios.forEach(usuario => {
            const usuarioItem = document.createElement('div');
            usuarioItem.innerText = `Nome: ${usuario.nome}, Email: ${usuario.email}, Telefone: ${usuario.telefone}`;
            usuariosLista.appendChild(usuarioItem);
        });
    })
    .catch(error => console.error('Erro ao listar usuários:', error));
}