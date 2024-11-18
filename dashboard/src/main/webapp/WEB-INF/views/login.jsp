<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/715bfff934.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

   <style>
   @import url('https://fonts.googleapis.com/css?family=Raleway:400,700');

   * {
       box-sizing: border-box;
       margin: 0;
       padding: 0;
       font-family: Raleway, sans-serif;
   }

   .container {
       display: flex;
       align-items: center;
       justify-content: center;
       min-height: 100vh;
   }

   /* Banner CSS */
   .banner {
       width: 50%;
       height: 600px;
       display: flex;
       flex-direction: column;
   }

   .banner-image {
       height: 80%;
       display: flex;
       justify-content: center;
       align-items: center;
       overflow: hidden;
   }

   .banner-image img {
       width: 100%;
       height: auto;
       object-fit: cover;
   }

   .banner-text {
       height: 20%;
       display: flex;
       flex-direction: column;
       justify-content: center;
       align-items: flex-start;
       background-color: #7E7BB9;
       padding-left: 20px;
   }

   .banner-text a {
       color: white;
       text-decoration: none;
       font-size: 16px;
       margin: 8px 0;
       font-weight: 600;
       letter-spacing: 1px;
       transition: color 0.3s ease, transform 0.3s ease;
       position: relative;
   }

   .banner-text a::before {
       content: '';
       position: absolute;
       bottom: -4px;
       left: 0;
       width: 0;
       height: 2px;
       background-color: white;
       transition: width 0.3s ease;
   }

   .banner-text a:hover::before {
       width: 100%;
   }

   .login__radio-group input[type="radio"]{
   margin-left: 14px;
   margin-right: 4px;
   }

   .login__radio-group label {
   font-size: 15px;
   }

   .banner-text a:hover {
       color: #d1d1d4;
       transform: translateX(5px);
   }

   /* Existing CSS for the screen */
   .screen {
       background: linear-gradient(90deg, #5D54A4, #7C78B8);
       position: relative;
       height: 600px;
       width: 360px;
       box-shadow: 0px 0px 24px #5C5696;
   }

   .screen__content {
       z-index: 1;
       position: relative;
       height: 100%;
       display: flex;
       flex-direction: column;
       justify-content: space-between;
       padding-bottom: 20px;
   }

   .screen__background {
       position: absolute;
       top: 0;
       left: 0;
       right: 0;
       bottom: 0;
       z-index: 0;
       -webkit-clip-path: inset(0 0 0 0);
       clip-path: inset(0 0 0 0);
   }

   .screen_background_shape {
       transform: rotate(45deg);
       position: absolute;
   }

   .screen_background_shape1 {
       height: 520px;
       width: 520px;
       background: #FFF;
       top: -50px;
       right: 120px;
       border-radius: 0 72px 0 0;
   }

   .screen_background_shape2 {
       height: 220px;
       width: 220px;
       background: #6C63AC;
       top: -172px;
       right: 0;
       border-radius: 32px;
   }

   .screen_background_shape3 {
       height: 540px;
       width: 190px;
       background: linear-gradient(270deg, #5D54A4, #6A679E);
       top: -24px;
       right: 0;
       border-radius: 32px;
   }

   .screen_background_shape4 {
       height: 400px;
       width: 200px;
       background: #7E7BB9;
       top: 420px;
       right: 50px;
       border-radius: 60px;
   }

   .login {
       width: 320px;
       padding: 30px;
       padding-top: 156px;
   }

   .login__field {
       padding: 20px 0px;
       position: relative;
   }

   .login__icon {
       position: absolute;
       top: 30px;
       color: #7875B5;
   }

   .login__input {
       border: none;
       border-bottom: 2px solid #D1D1D4;
       background: none;
       padding: 10px;
       padding-left: 24px;
       font-weight: 700;
       width: 75%;
       transition: .2s;
   }

   .login__input:active,
   .login__input:focus,
   .login__input:hover {
       outline: none;
       border-bottom-color: #6A679E;
   }

   .login__submit {
       background: #fff;
       font-size: 14px;
       margin-top: 30px;
       padding: 16px 20px;
       border-radius: 26px;
       border: 1px solid #D4D3E8;
       text-transform: uppercase;
       font-weight: 700;
       display: flex;
       align-items: center;
       width: 100%;
       color: #4C489D;
       box-shadow: 0px 2px 2px #5C5696;
       cursor: pointer;
       transition: .2s;
   }

   .login__submit:active,
   .login__submit:focus,
   .login__submit:hover {
       border-color: #6A679E;
       outline: none;
   }

   .button__icon {
       font-size: 24px;
       margin-left: auto;
       color: #7875B5;
   }

   .social-login {
       position: absolute;
       text-align: center;
       bottom: 0px;
       color: #fff;
       margin-top: auto;
       padding-bottom: 20px;
       padding-left: 86px;
   }
   .social-login h3 {
       font-size: 20px;
   }
   .social-login a {
       text-decoration: none;
       color: black;
   }

   .social-icons {
       display: flex;
       align-items: center;
       justify-content: center;
   }

   .social-login__icon {
       padding: 20px 10px;
       color: #fff;
       font-size: 24px;
   }

   @media (max-width: 800px) {
       .banner {
           width: 100%;
       }
       .screen {
           width: 100%;
       }
   }

   </style>
</head>
<body>
   <div class="container">
       <div class="banner">
           <div class="banner-image">
               <img src="/images/preview.webp" alt="Banner" />
           </div>
           <div class="banner-text">
               <a href="#">How to Login ?</a>
               <a href="#">Help ?</a>
               <a href="#">Contact Us</a>
           </div>
       </div>
       <div class="screen">
           <div class="screen__content">
             <form class="login" action="/dashboard" method="post">
              <div class="login__field">
                     <div class="login__radio-group">
                         <input type="radio" id="student" name="role" value="student" required>
                         <label for="student">Student</label>

                         <input type="radio" id="teacher" name="role" value="teacher">
                         <label for="teacher">Teacher</label>
                     </div>
                 </div>
                   <div class="login__field">
                       <i class="login__icon fas fa-user"></i>
                       <input type="text" class="login__input" placeholder="Username" name="rollNo" required>
                   </div>
                   <div class="login__field">
                       <i class="login__icon fas fa-lock"></i>
                       <input type="password" class="login__input" placeholder="Password" name="barcode" required>
                   </div>
                   <button class="button login__submit">
                       <span class="button__text">Log In</span>
                       <i class="button__icon fas fa-chevron-right"></i>
                   </button>
               </form>
               <div class="social-login">
                   <h3><a href="#"> Forgotten password?</a></h3>
               </div>
           </div>
           <div class="screen__background">
               <span class="screen_background_shape screen_background_shape4"></span>
               <span class="screen_background_shape screen_background_shape3"></span>
               <span class="screen_background_shape screen_background_shape2"></span>
               <span class="screen_background_shape screen_background_shape1"></span>
           </div>
       </div>
   </div>

  <!-- Bootstrap modal for login success/failure -->
      <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
          <div class="modal-dialog">
              <div class="modal-content">
                  <div class="modal-header">
                      <h5 class="modal-title" id="loginModalLabel">Login Status</h5>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                      <c:choose>
                          <c:when test="${loginStatus == 'failed'}">
                              <div class="alert alert-danger" role="alert">
                                  Login Failed. Please check your username and password.
                              </div>
                          </c:when>
                      </c:choose>
                  </div>
              </div>
          </div>
      </div>

      <!-- Bootstrap JS and dependencies -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

      <script>
          // Show modal if loginStatus is set in the request
          <% if (request.getAttribute("loginStatus") != null) { %>
              var loginModal = new bootstrap.Modal(document.getElementById('loginModal'));
              loginModal.show();
          <% } %>
      </script>
</body>
</html>