const blockedMessage = document.querySelector('.blocked-message');

blockedImage.addEventListener('mouseenter', function () {
    blockedMessage.style.visibility = 'visible';
});

blockedImage.addEventListener('mouseleave', function () {
    blockedMessage.style.visibility = 'hidden';
});