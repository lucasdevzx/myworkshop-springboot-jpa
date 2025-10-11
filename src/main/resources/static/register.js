document.getElementById('register-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const password = document.getElementById('password').value;

    const newUser = {
        name,
        email,
        phone,
        password
    };

    fetch('/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newUser)
    })
    .then(response => {
        if (response.ok) {
            alert('Registro bem-sucedido! Você será redirecionado para a página de login.');
            window.location.href = 'index.html';
        } else {
            // Try to get error message from backend if available
            response.json().then(err => {
                alert(`Erro no registro: ${err.message || 'Verifique os dados e tente novamente.'}`);
            }).catch(() => {
                alert('Erro no registro. Verifique os dados e tente novamente.');
            });
        }
    })
    .catch(error => {
        console.error('Registration error:', error);
        alert('Ocorreu um erro de rede ao tentar se registrar.');
    });
});
