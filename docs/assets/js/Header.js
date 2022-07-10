const navbar = document.querySelector('.fixed-top');
window.onscroll = () => {
    if (window.scrollY > 20) {
        navbar.classList.add('header-active');
    } else {
        navbar.classList.remove('header-active');
    }
};