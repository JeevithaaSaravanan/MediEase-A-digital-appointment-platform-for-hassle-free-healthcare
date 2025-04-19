// Wait until the DOM is fully loaded before executing scripts
document.addEventListener("DOMContentLoaded", function () {
    
    // Admin Panel Sections
    const doctorSection = document.getElementById('doctorSection');
    const appointmentSection = document.getElementById('appointmentSection');
    const paymentSection = document.getElementById('paymentSection');

    // Admin Panel Navigation Links
    const manageDoctors = document.getElementById('manageDoctors');
    const viewAppointments = document.getElementById('viewAppointments');
    const trackPayments = document.getElementById('trackPayments');
     
    // Ensure all sections are initially hidden
    doctorSection.classList.add('hidden');
    appointmentSection.classList.add('hidden');
    paymentSection.classList.add('hidden');

    // Manage Doctors Section
    manageDoctors.addEventListener('click', (event) => {
        event.preventDefault();
        doctorSection.classList.remove('hidden');
        appointmentSection.classList.add('hidden');
        paymentSection.classList.add('hidden');
    });

    // View Appointments Section
    viewAppointments.addEventListener('click', (event) => {
        event.preventDefault();
        doctorSection.classList.add('hidden');
        appointmentSection.classList.remove('hidden');
        paymentSection.classList.add('hidden');
    });

    // Track Payments Section
    trackPayments.addEventListener('click', (event) => {
        event.preventDefault();
        doctorSection.classList.add('hidden');
        appointmentSection.classList.add('hidden');
        paymentSection.classList.remove('hidden');
    });
});
//JavaScript to handle the form toggling behavior
    document.getElementById('registerBtn').addEventListener('click', function() {
        document.getElementById('registrationForm').style.display = 'block';
    });

    // Close the form when the user clicks anywhere outside the form container
    window.addEventListener('click', function(event) {
        const formContainer = document.getElementById('registrationForm');
        
        // If the click is outside the form, hide the form
        if (!formContainer.contains(event.target) && event.target !== document.getElementById('registerBtn')) {
            formContainer.style.display = 'none';
        }
    });
    // Show/Hide Registration Form
    registerBtn.addEventListener('click', () => {
        registrationForm.classList.toggle('hidden');
    });