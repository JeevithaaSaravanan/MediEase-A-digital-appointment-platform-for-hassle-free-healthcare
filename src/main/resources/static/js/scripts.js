document.addEventListener("DOMContentLoaded", function () {
    const registerBtn = document.getElementById("registerBtn");
    const formContainer = document.getElementById("registrationForm");
    const form = document.getElementById("appointmentForm");
  
    // Toggle form visibility
    if (registerBtn && formContainer) {
      registerBtn.addEventListener("click", () => {
        formContainer.classList.remove("hidden");
        formContainer.style.display = "block";
      });
  
      window.addEventListener("click", function (event) {
        if (!formContainer.contains(event.target) && event.target !== registerBtn) {
          formContainer.style.display = "none";
        }
      });
    }
  
    // Show/hide payment options
    const paymentMethodSelect = document.getElementById("payment_method");
    const cashOptions = document.getElementById("cashOptions");
    const upiOptions = document.getElementById("upiOptions");
    const qrCode = document.getElementById("upiQRCode");
  
    if (paymentMethodSelect) {
      paymentMethodSelect.addEventListener("change", function () {
        const value = paymentMethodSelect.value;
        cashOptions.style.display = "none";
        upiOptions.style.display = "none";
        qrCode.style.display = "none";
  
        if (value === "Cash") {
          cashOptions.style.display = "block";
        } else if (value === "UPI") {
          upiOptions.style.display = "block";
          qrCode.style.display = "block";
        }
      });
    }
});
  