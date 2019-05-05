var campoFiltro = document.querySelector("#filtrar-tabela");
var campoEmail = document.querySelector("#filtrar-email");


campoFiltro.addEventListener("input", function() {
    var usuarios = document.querySelectorAll(".usuario");
    console.log(this.value);
    if (this.value.length > 0) {
            for (var i = 0; i < usuarios.length; i++) {
            var usuario = usuarios[i];
            var tdNome = usuario.querySelector(".info-nome");
            var nome = tdNome.textContent;
            
            var expressao = new RegExp(campoFiltro.value, "i");

            if (!expressao.test(nome)) {
                usuario.classList.add("invisivel");
            } else {
                usuario.classList.remove("invisivel");
            }
        }
    } else {
        for (var i = 0; i < usuarios.length; i++) {
            var usuario = usuarios[i];
            usuario.classList.remove("invisivel");
        }
    }
});


campoEmail.addEventListener("input", function() {
    var usuarios = document.querySelectorAll(".usuario");
   
    if (campoEmail.value.length > 0) {
            for (var i = 0; i < usuarios.length; i++) {
            var usuario = usuarios[i];
            var tdEmail = usuario.querySelector(".info-email");
            var email = tdEmail.textContent;
            
            var expressao = new RegExp(campoEmail.value, "i");

            if (!expressao.test(email)) {
                usuario.classList.add("invisivel");
            } else {
                usuario.classList.remove("invisivel");
            }
        }
    } else {
        for (var i = 0; i < usuarios.length; i++) {
            var usuario = usuarios[i];
            usuario.classList.remove("invisivel");
        }
    }
});



