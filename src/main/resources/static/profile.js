document.addEventListener('DOMContentLoaded', () => {
    const userId = sessionStorage.getItem('userId');

    if (!userId) {
        // If no user is logged in, redirect to login page
        window.location.href = 'index.html';
        return;
    }

    fetch(`/users/${userId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch user data');
            }
            return response.json();
        })
        .then(user => {
            const userDetailsContainer = document.getElementById('user-details');
            userDetailsContainer.innerHTML = `
                <p><strong>ID:</strong> ${user.id}</p>
                <p><strong>Nome:</strong> ${user.name}</p>
                <p><strong>Email:</strong> ${user.email}</p>
                <p><strong>Telefone:</strong> ${user.phone}</p>
            `;
        })
        .catch(error => {
            console.error('Profile error:', error);
            alert('Não foi possível carregar os dados do perfil.');
            // Maybe redirect to login if fetching fails
            window.location.href = 'index.html';
        });

    document.getElementById('logout-link').addEventListener('click', (e) => {
        e.preventDefault();
        sessionStorage.removeItem('userId');
        window.location.href = 'index.html';
    });
});
