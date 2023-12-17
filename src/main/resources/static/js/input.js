var inputs = document.querySelectorAll(".input-val");
inputs.forEach(input => {
    if (input.value != "") {
        input.nextElementSibling.classList.add('active');
    }
    input.onfocus = () => {
        input.nextElementSibling.classList.add('val');
        input.nextElementSibling.classList.add('active');
        input.classList.add('inp-active');
    }
    input.onblur = () => {
        input.nextElementSibling.classList.remove('val');
        input.classList.remove('inp-active');
        if (input.value != "") {
        } else {
            input.nextElementSibling.classList.remove('active');
        }
    }
})

var dates = document.querySelectorAll(".date-val");
dates.forEach(input => {
    input.onfocus = () => {
        input.classList.add('date-active');
    }
    input.onblur = () => {
        input.classList.remove('date-active');
        if (input.value != "") {
        }
    }
})

var checks = document.querySelectorAll(".check-val");
checks.forEach(input => {
    if (input.checked) {
        input.parentElement.classList.add("check-active");
        input.nextElementSibling.nextElementSibling.classList.add("lab-check-active");
    }
    input.onclick = () => {
        if (input.checked) {
            input.parentElement.classList.add("check-active");
            input.nextElementSibling.nextElementSibling.classList.add("lab-check-active");
        } else {
            input.parentElement.classList.remove("check-active");
            input.nextElementSibling.nextElementSibling.classList.remove("lab-check-active");
        }
    }
})

var avalible = document.querySelectorAll(".prueba");
avalible.forEach(input => {
    if (input.checked) {
        input.parentElement.classList.add("switch-act");
        input.nextElementSibling.nextElementSibling.classList.add("slider-act");
    }
    input.onclick = () => {
        if (input.checked) {
            input.parentElement.classList.add("switch-act");
            input.nextElementSibling.nextElementSibling.classList.add("slider-act");
        } else {
            input.parentElement.classList.remove("switch-act");
            input.nextElementSibling.nextElementSibling.classList.remove("slider-act");
        }
    }
})

function alternarClase(radio) {
    var radios = document.querySelectorAll('.radio-val');
    radios.forEach(function (r) {
        // Quita la clase de todos los radios
        r.parentElement.classList.remove("check-active");
        r.nextElementSibling.nextElementSibling.classList.remove("lab-check-active");
    });

    if (radio.checked) {
        // Si el radio está marcado, agrega la clase
        radio.parentElement.classList.add("check-active");
        radio.nextElementSibling.nextElementSibling.classList.add("lab-check-active");
    }
}

var radio = document.querySelectorAll(".radio-val");
radio.forEach(input => {

    input.onclick = () => {

        radio.forEach(input => {
            input.parentElement.classList.remove("radio-active");
            input.nextElementSibling.classList.remove("lab-radio-active");
        });

        if (input.checked) {
            input.parentElement.classList.add("radio-active");
            input.nextElementSibling.classList.add("lab-radio-active");
        }
    }
})

function nextStep1a2(){
    var Step1 = document.getElementById("paso1");
    var Step2 = document.getElementById("paso2");
    var num = document.getElementById("paso2a");

    num.classList.add("act-pb");
    Step1.classList.remove("step-active");
    Step2.classList.add("step-active");
}

function prevStep2a1(){
    var Step1 = document.getElementById("paso1");
    var Step2 = document.getElementById("paso2");
    var num = document.getElementById("paso2a");

    num.classList.remove("act-pb");
    Step1.classList.add("step-active");
    Step2.classList.remove("step-active");
}

function prevStep2a3(){
    var Step2 = document.getElementById("paso2");
    var Step3 = document.getElementById("paso3");
    var num = document.getElementById("paso3a");

    num.classList.add("act-pb");
    Step2.classList.remove("step-active");
    Step3.classList.add("step-active");
}

function prevStep3a2(){
    var Step2 = document.getElementById("paso2");
    var Step3 = document.getElementById("paso3");
    var num = document.getElementById("paso3a");

    num.classList.remove("act-pb");
    Step2.classList.add("step-active");
    Step3.classList.remove("step-active");
}