function animateButton() {
    var button = document.querySelector('.animated-button');
    button.classList.add('animate');

    setTimeout(function() {
        button.classList.remove('animate');
    }, 2000);
}