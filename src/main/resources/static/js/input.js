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
        if(input.checked){
            input.parentElement.classList.add("switch-act");
            input.nextElementSibling.nextElementSibling.classList.add("slider-act");
        } else {
            input.parentElement.classList.remove("switch-act");
            input.nextElementSibling.nextElementSibling.classList.remove("slider-act");
        }
    }
})