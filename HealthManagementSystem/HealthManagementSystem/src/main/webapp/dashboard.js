/**
 * 
 */
const vitalsLink = document.querySelector('#vitals-link');
const vitalsMenu = document.querySelector('#vitals-menu');

vitalsLink.addEventListener('click', function(e) {
  e.preventDefault();
  vitalsMenu.classList.toggle('show');
});