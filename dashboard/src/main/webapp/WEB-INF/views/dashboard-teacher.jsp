<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
            @import url('https://fonts.googleapis.com/css?family=Raleway:400,700');

            * {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
                font-family: 'Raleway', sans-serif;
            }

            body {
                font-family: 'Raleway', sans-serif;
                background: linear-gradient(90deg, #5D54A4, #7C78B8);
                margin: 0;
                padding: 0;
            }

            .dashboard_t {
                display: flex;
                height: auto;
                justify-content: space-between;
                padding: 20px;
                gap: 20px;
                flex-direction: row;

            }

            .profile-section_t {
                flex: 1;
                padding: 20px;
                display: flex;
                flex-direction: column;
                align-items: flex-start;
                justify-content: space-between;
                background-color: #FFF;
                box-shadow: 0px 2px 2px #5C5696;
                border-radius: 12px;
                position: relative;
            }

            .profile-section_t h1 {
                position: absolute;
                top: 20px;
                left: 20px;
                color: #4C489D;
                font-size: 35px;
                text-transform: uppercase;
                padding-top: 11px;
            }

            .profile-section_t .profile_t {
                flex: 1;
                display: flex;
                flex-direction: column;
                justify-content: flex-start;
                margin-bottom: 20px;
            }

            .profile-section_t .profile_t img {
                width: 50px;
                height: 50px;
                border-radius: 50%;
                margin-bottom: 15px;
                position: absolute;
                top: 20px;
                right: 20px;
            }

            .profile-icon-effect {
                transform: scale(1.1);
                transition: transform 0.3s ease, filter 0.3s ease, box-shadow 0.3s ease;
                filter: brightness(1.2);
                box-shadow: 0 0 10px rgba(255, 0, 0, 0.5);
            }

            .profile-icon-effect:hover {
                box-shadow: 0 0 15px rgba(0, 0, 255, 0.7);/
            }

            .separator_t {
                height: 0.9px;
                width: 40%;
                background-color: #4C489D;
                margin: 15px 0;
            }

            .profile-section_t .details_t {
                width: 100%;
                text-align: left;
                margin-top: 80px;
            }

            .details_t p {
                margin: 5px 0;
                font-weight: 400;
                color: #4C489D;
            }

            .logout-btn_t {
                background-color: #FF4C4C;
                color: white;
                border: none;
                padding: 10px 20px;
                cursor: pointer;
                border-radius: 4px;
                box-shadow: 0px 2px 2px #5C5696;
                margin-top: 15px;
                text-align: center;
                align-self: center;
            }

            .main-screen_t {
                flex: 3;
                background-color: #FFF;
                padding: 20px;
                position: relative;
                border-radius: 12px;
                box-shadow: 0px 2px 2px #5C5696;
            }

            .main-screen_t .content_t {
                display: flex;
                align-items: center;
                padding: 30px 0px 0px 49px;
                gap: 26px;
            }

            .button-container_t {
                margin-right: 20px;
            }

            .main-screen_t .content_t .download-btn_t {
                background: #fff;
                font-size: 18px;
                padding: 15px 98px;
                border-radius: 4px;
                border: 1px solid #D4D3E8;
                text-transform: uppercase;
                font-weight: 700;
                color: #4C489D;
                box-shadow: 0px 2px 2px #5C5696;
                cursor: pointer;
                transition: 0.2s;
            }

            .main-screen_t .content_t .download-btn_t:hover {
                border-color: #6A679E;
                color: #6A679E;
            }

            .dash-div_t {
                background-color: rgba(76, 72, 157, 0.1);
            }

            .download-btn_t i {
                margin-right: 10px;
            }

            .subject-section_t {
                margin-top: 30px;
                text-align: left;
                padding-left: 50px;
            }

            .subject-section_t h2 {
                color: #4C489D;
                font-size: 24px;
                margin-bottom: 20px;
            }

            .subject-buttons_t {
                display: flex;
                gap: 15px;
            }

            .subject-btn_t {
                background: #fff;
                font-size: 16px;
                padding: 13px 30px;
                border-radius: 4px;
                border: 1px solid #D4D3E8;
                text-transform: uppercase;
                font-weight: 700;
                color: #4C489D;
                box-shadow: 0px 2px 2px #5C5696;
                cursor: pointer;
                transition: 0.2s;
            }

            .subject-btn_t:hover {
                border-color: #6A679E;
                color: #6A679E;
            }

            .cards-container {
                display: flex;
                gap: 20px;
                flex-wrap: wrap;
            }

            .card {
                background-color: #ffffff;
                border-radius: 20px;
                box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
                padding: 20px;
                width: 169px;
                text-align: center;
                position: relative;
            }

            .icon-container {
                width: 50px;
                height: 50px;
                background-color: #ff4757;
                border-radius: 50%;
                display: flex;
                justify-content: center;
                align-items: center;
                margin: 0 auto;
                margin-bottom: 10px;
            }

            .card-content h3 {
                color: #333;
                margin-bottom: 5px;
                font-size: 18px;
            }

            .card-content h2 {
                color: #333;
                font-size: 24px;
                margin-bottom: 5px;
            }

            .card-content p {
                color: #888;
                font-size: 14px;
            }

            .progress-circle {
                position: absolute;
                bottom: 15px;
                right: 15px;
                width: 42px;
                height: 42px;
                border-radius: 50%;
                border: 5px solid #dfe4ea;
                display: flex;
                justify-content: center;
                align-items: center;
                color: #888;
                font-size: 10px;
                font-weight: 700;
            }

            .progress-circle{

                width: 42px;
                height: 42px;
                box-shadow: inset 0 0 7px grey;
                border-left-color: palegreen;
                border-top-color: chartreuse;
                border-right-color: darkgreen;
                border-bottom-color: white;
                text-align: center;
                box-sizing: border-box;
            }
             .progress-circle::before {
                 content: attr(data-percent) '%';
                 font-size: 12px;
             }

            .icon-container img {
                width: 30px;
                height: 30px;
            }

            /* The Modal (background) */
            .modal_t {
                display: none;
                position: absolute;
                z-index: 1;
                left: 50px;
                top: 94px;
                width: 300px;
                background-color: rgba(0, 0, 0, 0.4);
                justify-content: center;
                align-items: center;
                border-radius: 12px;
                box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            }

            .modal-content_t {
                background-color: #fff;
                border-radius: 10px;
                width: 100%;
                text-align: center;
                position: relative;
                display: flex;
                flex-direction: column;
                align-items: center;
                padding-bottom: 25px;
            }

            .profile-header_t {
                position: relative;
                width: 100%;
                height: 100px;
                background-color: #7C78B8;
                border-top-left-radius: 10px;
                border-top-right-radius: 10px;
            }

            .user-img_t {
                width: 80px;
                height: 80px;
                border-radius: 50%;
                border: 3px solid white;
                position: absolute;
                top: 50px;
                left: 50%;
                transform: translateX(-50%);
            }

            h3 {
                margin-top: 40px;
                font-size: 18px;
                font-weight: bold;
                color: #333;
            }

            p {
                font-size: 14px;
                color: #666;
                margin: 5px 0;
            }

            .icon-row_t {
                margin-top: 20px;
                display: flex;
                justify-content: center;
            }

            .icon-row_t i {
                font-size: 24px;
                margin: 0 10px;
                cursor: pointer;
            }

            .icon-row_t i:hover {
                color: #000;
            }

            .other-profiles_t {
                margin-top: 20px;
            }

            .other-profiles_t ul {
                list-style-type: none;
                padding-left: 0;
            }

            .other-profiles_t li {
                display: flex;
                align-items: center;
                padding: 5px 0;
                font-size: 16px;
            }



            @media (max-width: 1200px) {
                .dashboard_t {
                    flex-direction: column;
                    height: auto;
                }

                .profile-section_t {
                    margin-bottom: 20px;
                }
            }

            @media (max-width: 768px) {
                .dashboard_t {
                    padding: 10px;
                }

                .profile-section_t h1 {
                    font-size: 20px;
                }

                .main-screen_t .content_t .download-btn_t {
                    padding: 10px 20px;
                    font-size: 16px;
                }

                .cards-container {
                    gap: 10px;
                }

            }

            @media (max-width: 576px) {
                .profile-section_t img {
                    width: 80px;
                    height: 80px;
                }

                .main-screen_t .content_t .download-btn_t {
                    width: 100%;
                }

                .main-screen_t .content_t {
                    flex-direction: column;
                    padding-left: 9px;
                }

                .main-screen_t .content_t .download-btn_t {
                    padding: 12px 23px;
                    font-size: 14px;
                }

                .subject-section_t {
                    margin-top: 30px;
                    text-align: left;
                    padding-left: 20px;
                }

            }

            @media (max-width: 576px) {
                .main-screen_t .content_t .download-btn_t {
                    font-size: 13px;
                }

                .subject-section_t h2 {
                    font-size: 17px;
                }

                .subject-section_t {
                    padding-left: 11px;
                }

                .card-content h3 {
                    font-size: 15px;
                }
            }

            @media (max-width: 768px) {
                .card {
                    width: calc(50% - 20px);
                }

                .cards-container {
                    gap: 10px;
                    padding-right: 18px;
                }
            }

            @media (max-width: 576px) {
                .card {
                    width: 100%;
                }
            }
            .main-screen_t {
        display: flex;
        flex-direction: column;
        flex-wrap: nowrap;
    }
        </style>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const counters = document.querySelectorAll('.count');

                counters.forEach(counter => {
                    const updateCount = () => {
                        const target = +counter.getAttribute('data-target');
                        const count = +counter.innerText;

                        let increment;
                        if (target < 100) {
                            increment = Math.ceil(target / 20);
                        } else {
                            increment = Math.ceil(target / 100);
                        }

                        if (count < target) {
                            counter.innerText = Math.min(count + increment, target);
                            setTimeout(updateCount, 40);
                        } else {
                            counter.innerText = target;
                        }
                    };
                    // Initialize count at 0
                    counter.innerText = 0;
                    updateCount();
                });
            });

let totalStudents = ${totalStudents};
let englishStudents = ${englishStudents};
let gkStudents = ${gkStudents};
let scienceStudents = ${scienceStudents};
let mathsStudents = ${mathsStudents};
let ssStudents = ${ssStudents};
let sevenStudents = ${sevenStudents};
let eightStudents = ${eightStudents};
let nineStudents = ${nineStudents};

function calculatePercentage(subjectStudents, totalStudents) {
    return (subjectStudents / ${totalStudents}) * 100;
}

function calculatePercentage1(classStudents, totalStudents) {
    return (classStudents / totalStudents) * 100;
}

function animateProgress(element, targetPercentage) {
    if (!element) return; // Exit if element is null
    let currentPercentage = 0;
    const interval = setInterval(function() {
        if (currentPercentage >= targetPercentage) {
            clearInterval(interval);
        } else {
            currentPercentage++;
            element.setAttribute('data-percent', currentPercentage);
            element.style.background = `conic-gradient(#4caf50 ${currentPercentage}%, #ddd ${currentPercentage}%)`;
        }
    }, 20);
}


window.onload = function() {

    let englishPercentage = calculatePercentage(englishStudents, totalStudents);
    let gkPercentage = calculatePercentage(gkStudents, totalStudents);
    let sciencePercentage = calculatePercentage(scienceStudents, totalStudents);
    let mathsPercentage = calculatePercentage(mathsStudents, totalStudents);
    let ssPercentage = calculatePercentage(ssStudents, totalStudents);

    animateProgress(document.querySelector(".card:nth-child(1) .progress-circle"), englishPercentage);
    animateProgress(document.querySelector(".card:nth-child(2) .progress-circle"), gkPercentage);
    animateProgress(document.querySelector(".card:nth-child(3) .progress-circle"), sciencePercentage);
    animateProgress(document.querySelector(".card:nth-child(4) .progress-circle"), mathsPercentage);
    animateProgress(document.querySelector(".card:nth-child(5) .progress-circle"), ssPercentage);

    let sevenPercentage = calculatePercentage1(sevenStudents, totalStudents);
    let eightPercentage = calculatePercentage1(eightStudents, totalStudents);
    let ninePercentage = calculatePercentage1(nineStudents, totalStudents);

    console.log("Seven Percentage:", sevenPercentage);
    console.log("Eight Percentage:", eightPercentage);
    console.log("Nine Percentage:", ninePercentage);

    animateProgress(document.querySelector(".card:nth-child(6) .progress-circle"), sevenPercentage);
    animateProgress(document.querySelector(".card:nth-child(7) .progress-circle"), eightPercentage);
    animateProgress(document.querySelector(".card:nth-child(8) .progress-circle"), ninePercentage);
}

        </script>
</head>

<body>

    <div class="dashboard_t row">
        <div class="profile-section_t xl-col-2">
             <div class="profile_t">
                            <div class="dash-div_t">
                                <h1>Dashboard</h1>
                                <img id="profileIcon" class="profileIcon" onmouseover="showModal()" onmouseout="hideModal()" onclick="toggleModal()" src="/images/user.png" alt="Profile Icon">
                            </div>
                        </div>
            <button class="logout-btn_t" onclick="location.href='/logout'">Logout</button>
        </div>

        <div class="main-screen_t xl-col-8">
            <div class="content_t">
                <div class="button-container_t">
                    <button id="totalCandidatesBtn" class="download-btn_t" onclick="location.href='/showtotalstudent'">
                           Total Candidates (${totalStudents})
                        </button>
                </div>
            </div>

            <!-- New Section for Subject-wise Buttons -->
            <div class="subject-section_t">
                            <h2>Subject Wise Student Details</h2>
                            <div class="cards-container" id="cardsContainer1">
                                <!-- Hardcoded 5 cards -->
                               <div class="card" onclick="location.href='/englishstudentlist'">
                                   <div class="icon-container" style="background-color: #ff6b6b;">
                                       <img src="images/education.png" alt="Icon" />
                                   </div>
                                   <div class="card-content">
                                       <h3>English</h3>
                                       <h2 class="count" data-target="${englishStudents}">${englishStudents}</h2>
                                       <div class="progress-circle" data-percent="0"></div> <!-- Default 0, will be updated dynamically -->
                                   </div>
                               </div>

                               <div class="card" onclick="location.href='/gkstudentlist'">
                                   <div class="icon-container" style="background-color: #ff6b6b;">
                                       <img src="images/education.png" alt="Icon" />
                                   </div>
                                   <div class="card-content">
                                       <h3>General Knowledge</h3>
                                       <h2 class="count" data-target="${gkStudents}">${gkStudents}</h2>
                                       <div class="progress-circle" data-percent="0"></div>
                                   </div>
                               </div>

                               <div class="card" onclick="location.href='/sciencestudentlist'">
                                   <div class="icon-container" style="background-color: #2ed573;">
                                       <img src="images/education.png" alt="Icon" />
                                   </div>
                                   <div class="card-content">
                                       <h3>Science</h3>
                                       <h2 class="count" data-target="${scienceStudents}">${scienceStudents}</h2>
                                       <div class="progress-circle" data-percent="0"></div>
                                   </div>
                               </div>

                               <div class="card" onclick="location.href='/mathsstudentlist'">
                                   <div class="icon-container" style="background-color: #1e90ff;">
                                       <img src="images/education.png" alt="Icon" />
                                   </div>
                                   <div class="card-content">
                                       <h3>Maths</h3>
                                       <h2 class="count" data-target="${mathsStudents}">${mathsStudents}</h2>
                                       <div class="progress-circle" data-percent="0"></div>
                                   </div>
                               </div>

                               <div class="card" onclick="location.href='/ssstudentlist'">
                                   <div class="icon-container" style="background-color: #ff6b6b;">
                                       <img src="images/education.png" alt="Icon" />
                                   </div>
                                   <div class="card-content">
                                       <h3>Social Science</h3>
                                       <h2 class="count" data-target="${ssStudents}">${ssStudents}</h2>
                                       <div class="progress-circle" data-percent="0"></div>
                                   </div>
                               </div>
                            </div>
            </div>
     <div class="subject-section_t">
                <h2>Class Wise Student Details</h2>
                <div class="cards-container" id="cardsContainer2">
                    <!-- Hardcoded 3 cards -->
                    <div class="card" onclick="location.href='/classsevenstudents'">
                        <div class="icon-container" style="background-color: #ff6b6b;">
                            <img src="images/education.png" alt="Icon" />
                        </div>
                        <div class="card-content">
                            <h3>Class 7</h3>
                            <h2 class="count" data-target="${sevenStudents}">${sevenStudents}</h2>
                            <div class="progress-circle" data-percent="0"></div>
                        </div>
                    </div>

                    <div class="card" onclick="location.href='/classeightstudents'">
                        <div class="icon-container" style="background-color: #2ed573;">
                            <img src="images/education.png" alt="Icon" />
                        </div>
                        <div class="card-content">
                            <h3>Class 8</h3>
                            <h2 class="count" data-target="${eightStudents}">${eightStudents}</h2>
                            <div class="progress-circle" data-percent="0"></div>
                        </div>
                    </div>

                    <div class="card" onclick="location.href='/classninestudents'">
                        <div class="icon-container" style="background-color: #1e90ff;">
                            <img src="images/education.png" alt="Icon" />
                        </div>
                        <div class="card-content">
                            <h3>Class 9</h3>
                            <h2 class="count" data-target="${nineStudents}">${nineStudents}</h2>
                            <div class="progress-circle" data-percent="0"></div>
                        </div>
                    </div>
                </div>
     </div>
        </div>

            <div id="profileModal" class="modal_t">
                        <div class="modal-content_t">
                            <div class="profile-header_t">
                                <div class="header-background_t"></div>
                                <img src="/images/user.png" alt="User Image" class="user-img_t">
                            </div>
                            <h3>${teacher.studentName}</h3>
                            <p>School: ${teacher.schoolName}</p>
                            <p>UDISE: ${teacher.udise}</p>
                        </div>
                    </div>
    </div>
 <script>
     let hideTimeout;

                   function toggleModal() {
                       var modal = document.getElementById("profileModal");
                       var profileIcon = document.getElementById("profileIcon");

                       if (modal.style.display === "none" || modal.style.display === "") {
                           modal.style.display = "block";
                           profileIcon.classList.add("profile-icon-effect");
                       } else {
                           modal.style.display = "none";
                           profileIcon.classList.remove("profile-icon-effect");
                       }
                   }

                   function closeModal() {
                       document.getElementById("profileModal").style.display = "none";
                       document.getElementById("profileIcon").classList.remove("profile-icon-effect");
                   }

                   function showModal() {
                       clearTimeout(hideTimeout);
                       document.getElementById("profileModal").style.display = "block";
                       document.getElementById("profileIcon").classList.add("profile-icon-effect");
                   }

                   function hideModal() {
                       hideTimeout = setTimeout(function () {
                           document.getElementById("profileModal").style.display = "none";
                           document.getElementById("profileIcon").classList.remove("profile-icon-effect"); // Remove effect
                       }, 200);
                   }

                   document.getElementById("profileModal").addEventListener("mouseover", function () {
                       clearTimeout(hideTimeout);
                   });

                   document.getElementById("profileModal").addEventListener("mouseout", function () {
                       hideModal();
                   });
    </script>
</body>

</html>