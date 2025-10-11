document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const loginData = {
        email: email,
        password: password
    };

    fetch('/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(loginData)
    })
    .then(response => {
        if (response.ok) {
            return response.json(); // Login successful, continue to get user data
        } else {
            // Login failed (e.g., 401 Unauthorized)
            throw new Error('Credenciais inválidas');
        }
    })
    .then(user => {
        // Store user ID from the response and redirect to profile
        sessionStorage.setItem('userId', user.id);
        window.location.href = 'profile.html';
    })
    .catch(error => {
        console.error('Login error:', error);
        alert(error.message || 'Ocorreu um erro ao tentar fazer o login.');
    });
});
