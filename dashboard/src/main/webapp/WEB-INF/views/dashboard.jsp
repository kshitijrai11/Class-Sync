<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
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

        .dashboard {
            display: flex;
            height: 100vh;
            justify-content: space-between;
            padding: 20px;
            gap: 20px;
            flex-direction: row;
        }

        .profile-section {
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

        .profile-section h1 {
            position: absolute;
            top: 20px;
            left: 20px;
            color: #4C489D;
            font-size: 35px;
            text-transform: uppercase;
            padding-top: 11px;
        }

        .profile-section .profile {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            margin-bottom: 20px;
        }

        .profile-section .profile img {
            width: 60px;
            height: 60px;
            border-radius: 50%;
            margin-bottom: 15px;
            position: absolute;
            top: 10px;
            right: 20px;
        }

        .separator {
            height: 0.9px;
            width: 40%;
            background-color: #4C489D;
            margin: 15px 0;
        }

        .profile-section .details {
            width: 100%;
            text-align: left;
            margin-top: 80px;
        }

        .details p {
            margin: 5px 0;
            font-weight: 400;
            color: #4C489D;
        }

        .logout-btn {
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

        .main-screen {
            flex: 3;
            background-color: #FFF;
            padding: 20px;
            position: relative;
            border-radius: 12px;
            box-shadow: 0px 2px 2px #5C5696;
        }

        .main-screen .content {
            display: flex;
            align-items: center;
            padding: 30px 0px 0px 29px;
        }

        .main-screen .content .download-btn {
            background: #fff;
            font-size: 18px;
            padding: 15px 30px;
            border-radius: 4px;
            border: 1px solid #D4D3E8;
            text-transform: uppercase;
            font-weight: 700;
            color: #4C489D;
            box-shadow: 0px 2px 2px #5C5696;
            cursor: pointer;
            transition: 0.2s;
        }

        .main-screen .content .download-btn:hover {
            border-color: #6A679E;
            color: #6A679E;
        }
        .dash-div{
            background-color: rgba(76, 72, 157, 0.1);
        }

        @media (max-width: 1200px) {
            .dashboard {
                flex-direction: column;
                height: auto;
            }

            .profile-section {
                margin-bottom: 20px;
            }
        }

        @media (max-width: 768px) {
            .dashboard {
                padding: 10px;
            }

            .profile-section h1 {
                font-size: 20px;
            }

            .main-screen .content .download-btn {
                padding: 10px 20px;
                font-size: 16px;
            }
        }

        @media (max-width: 576px) {
            .profile-section img {
                width: 80px;
                height: 80px;
            }

            .main-screen .content .download-btn {
                width: 100%;
            }
        }
    </style>
</head>

<body>

    <div class="dashboard row">
        <div class="profile-section xl-col-2">

            <div class="profile">
                <div class="dash-div">
                    <h1>Dashboard</h1>
                    <img src="images/user.png" alt="Profile Icon">
                </div>

                <div class="details">
                    <p>Name: ${user.studentName}</p>
                    <p>Mother Name: ${user.motherName}</p>
                    <p>Father Name: ${user.fatherName}</p>
                    <p>Roll No: ${user.rollNo}</p>
                    <p>School: ${user.schoolName}</p>
                    <p>Class: ${user.className}</p>
                    <p>Date Of Birth: ${user.dateOfBirth}</p>
                    <p>Centre Name: ${user.centreName}</p>
                    <p>Gender: ${user.gender}</p>
                    <p>Category: ${user.category}</p>
                    <p>Mobile Number: ${user.mobileNumber}</p>
                    <p>Subject: ${user.subject}</p>
                </div>
            </div>
            <button class="logout-btn" onclick="location.href='/logout'">Logout</button>
        </div>

        <div class="main-screen xl-col-8">
            <div class="content">
                <button class="download-btn" onclick="location.href='/download'">Download Admit Card</button>
            </div>
        </div>
    </div>

</body>

</html>
