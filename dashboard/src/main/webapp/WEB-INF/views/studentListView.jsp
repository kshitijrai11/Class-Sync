<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.studentportal.dashboard.User" %>
<%@ page import="com.google.gson.Gson" %>


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
               height: 100vh;
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

           .button-container {
               margin-bottom: 10px;
           }

           .select-all-btn,
           .download-btn {
               background-color: #4CAF50;
               color: white;
               border: none;
               padding: 10px 15px;
               cursor: pointer;
               border-radius: 5px;
               transition: background-color 0.3s, transform 0.2s;
           }

           .download-btn {
               background-color: #007BFF;
               margin-left: 6px;
           }

           .select-all-btn:hover,
           .download-btn:hover {
               background-color: #0056b3;
               transform: translateY(-2px);
           }

           .table-container {
               border-radius: 10px;
               box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
               background-color: #fff;
               flex-grow: 1;
               overflow-y: scroll;
           }


           table {
               width: 100%;
               border-collapse: collapse;
               min-width: 600px;
               border-radius: 10px;

           }

           th,
           td {
               padding: 12px;
               text-align: left;
               border-bottom: 1px solid #ddd;
           }

           th {
               background-color: #009688;
               color: white;
               font-weight: bold;
               text-align: center;
           }

           td {
               text-align: center;
           }

           tbody tr {
               transition: background-color 0.3s;
           }

   .selected {
       background-color: #e0f7fa;
       font-weight: bold;
       color: #00796b;
   }



           tbody tr:hover {
               background-color: #f1f1f1;
           }

           tbody tr:nth-child(odd) {
               background-color: #f9f9f9;
           }

           td input[type="checkbox"] {
               transform: scale(1.2);
               cursor: pointer;
           }

           .pagination-container {
               text-align: center;
               margin-top: 10px;
           }

           .pagination-btn {
               background-color: #007BFF;
               color: white;
               border: none;
               padding: 8px 15px;
               cursor: pointer;
               border-radius: 5px;
               margin: 0 5px;
               transition: background-color 0.3s;
           }

           .pagination-btn:hover {
               background-color: #0056b3;
           }

           .main-screen_t {
               flex: 3;
               background-color: #FFF;
               padding: 20px;
               position: relative;
               border-radius: 12px;
               box-shadow: 0px 2px 2px #5C5696;
               display: flex;
               flex-direction: column;
               justify-content: space-between;
               height: 100%;
           }

           #homeLink img {
               transition: transform 0.2s;
           }

           #homeLink:hover img {
               transform: scale(1.1);
           }
           /* modal */

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


           @media (max-width: 600px) {

               th,
               td {
                   font-size: 14px;
                   padding: 8px;
               }
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
           }

           @media (max-width: 576px) {
               .profile-section_t img {
                   width: 80px;
                   height: 80px;
               }
           }
       </style>
   <script>
   let selectedRows = new Set();

   function selectAll() {
       let checkboxes = document.querySelectorAll('#modalTableBody tr:not([style*="display: none"]) input[type="checkbox"]');

       if (checkboxes.length === 0) {
           console.error('No checkboxes found!');
           return;
       }

       let allChecked = Array.from(checkboxes).every(checkbox => checkbox.checked);

       checkboxes.forEach(checkbox => {
           checkbox.checked = !allChecked;
           let row = checkbox.closest('tr');

           if (checkbox.checked) {
               selectedRows.add(row);
               row.classList.add('selected');
           } else {
               selectedRows.delete(row);
               row.classList.remove('selected');
           }
       });

       reorderTable();
   }

   function reorderTable() {
       let tableBody = document.querySelector('#modalTableBody');
       let rows = Array.from(tableBody.querySelectorAll('tr'));

       let selected = rows.filter(row => selectedRows.has(row));
       let unselected = rows.filter(row => !selectedRows.has(row));

       tableBody.innerHTML = '';
       selected.forEach(row => tableBody.appendChild(row));
       unselected.forEach(row => tableBody.appendChild(row));
   }

   function addCheckboxListeners() {
       let checkboxes = document.querySelectorAll('#modalTableBody input[type="checkbox"]');

       checkboxes.forEach(checkbox => {
           checkbox.addEventListener('change', function() {
               let row = this.closest('tr');
               if (this.checked) {
                   selectedRows.add(row);
                   row.classList.add('selected');
               } else {
                   selectedRows.delete(row);
                   row.classList.remove('selected');
               }
               reorderTable();
           });
       });
   }

   document.addEventListener('DOMContentLoaded', () => {
       addCheckboxListeners();
   });
   </script>

<script>
   function searchTable() {
       let input = document.getElementById('searchInput').value.trim();
       console.log("Input Value:", input);
       let selectedColumnIndex = document.getElementById('filterColumn').value;
       console.log("Selected Column Index:", selectedColumnIndex);
       let tableBody = document.getElementById('modalTableBody');
       let rows = tableBody.getElementsByTagName('tr');

       for (let i = 0; i < rows.length; i++) {
           let cells = rows[i].getElementsByTagName('td');
           if (cells.length > 0) {
               let rowVisible = false;

               if (selectedColumnIndex == 0) {
                   for (let j = 0; j < cells.length; j++) {
                       let cellText = cells[j].textContent.toLowerCase();
                       if (input === '' || cellText.indexOf(input.toLowerCase()) > -1) {
                           rowVisible = true;
                           break;
                       }
                   }
               } else {
                   let cell = cells[selectedColumnIndex];
                   let cellText = cell.textContent.toLowerCase();

                   if (input === '' || (cell && cellText.indexOf(input.toLowerCase()) > -1)) {
                       rowVisible = true;
                   }
               }

               rows[i].style.display = rowVisible ? '' : 'none';
           }
       }
   }


</script>
<script>
    function goBack() {
        console.log("goBack function called");
        console.log("History length: ", window.history.length);

        if (window.history.length > 1) {
            window.history.back();
        } else {
            console.log("No history found, redirecting to dashboard.");
            window.location.href = '/dashboard-teacher';
        }
    }

    function downloadSelected() {
        // Get all selected checkboxes
        const selectedCheckboxes = document.querySelectorAll('.select-checkbox:checked');

        if (selectedCheckboxes.length === 0) {
            alert("Please select at least one student to download.");
            return;
        }

        // Collect the roll numbers of the selected students
        const selectedRollNumbers = Array.from(selectedCheckboxes).map(cb => cb.value);

        // Log the selected roll numbers to the console
        console.log("Selected Roll Numbers to send to server:", selectedRollNumbers);

        // Send the array of roll numbers to the server
        fetch('downloadzip', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(selectedRollNumbers) // Send the array directly
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.blob();  // Process the response if needed
        })
        .then(blob => {
            // Assuming you want to download the file after the server responds
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
            a.href = url;
            a.download = 'students-admit-cards.zip';  // Change to zip file name
            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

</script>

</head>

<body>
    <div class="dashboard_t row">
        <div class="profile-section_t xl-col-4">
            <div class="profile_t">
                            <div class="profile_t">
                                <div class="dash-div_t">
                                    <h1>Dashboard</h1>
                                    <img id="profileIcon" class="profileIcon" onmouseover="showModal()" onmouseout="hideModal()" onclick="toggleModal()" src="/images/user.png" alt="Profile Icon">
                                </div>
                            </div>
                        </div>
            <button class="logout-btn_t" onclick="location.href='/logout'">Logout</button>
        </div>

        <div class="main-screen_t xl-col-7">
            <div class="function_header" style="display: flex; justify-content: space-between; align-items: center;">
                <div class="button-container">
                    <button class="select-all-btn" onclick="selectAll()">Select All</button>
                    <button class="download-btn" onclick="downloadSelected()">Download Selected</button>
                </div>

                <div style="display: flex; align-items: center; width: 600px;">
                    <input type="text" id="searchInput" placeholder="Search..." onkeyup="searchTable()"
                        style="margin-bottom: 10px; padding: 8px; border-radius: 5px; border: 1px solid #000; flex: 1;">
                    <select id="filterColumn" style="margin-left: 10px; padding: 8px; border-radius: 5px; border: 1px solid #000; margin-bottom:10px">
                        <option value="0">Select filter</option>
                        <option value="1">Name</option>
                        <option value="2">Mother Name</option>
                        <option value="3">Father Name</option>
                        <option value="4">Roll No</option>
                        <option value="5">Class</option>
                        <option value="6">Date Of Birth</option>
                        <option value="7">Gender</option>
                        <option value="8">Mobile Number</option>
                        <option value="9">Subject</option>
                    </select>
                    <a href="javascript:void(0);" id="homeLink" style="text-decoration: none;padding: 0px 19px 10px 12px;" onclick="goBack(); return false;">
                        <img src="images/home-button.png" alt="Home" style="width: 30px; height: 30px;">
                    </a>
                </div>
            </div>

            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Select</th>
                            <th>Name</th>
                            <th>Mother Name</th>
                            <th>Father Name</th>
                            <th>Roll No</th>
                            <th>Class</th>
                            <th>Date Of Birth</th>
                            <th>Gender</th>
                            <th>Mobile Number</th>
                            <th>Subject</th>
                        </tr>
                    </thead>
                    <tbody id="modalTableBody">
                        <%
                           List<User> students = (List<User>) request.getAttribute("students");
                           if (students != null && !students.isEmpty()) {
                               for (User student : students) {
                        %>
                        <tr>
                            <td><input type="checkbox" class="select-checkbox" value="<%= student.getRollNo() %>"></td>
                            <td><%= student.getStudentName() %></td>
                            <td><%= student.getMotherName() %></td>
                            <td><%= student.getFatherName() %></td>
                            <td><%= student.getRollNo() %></td>
                            <td><%= student.getClassName() %></td>
                            <td><%= student.getDateOfBirth() %></td>
                            <td><%= student.getGender() %></td>
                            <td><%= student.getMobileNumber() %></td>
                            <td><%= student.getUdise() %></td>
                        </tr>
                        <%
                               }
                           }
                        %>
                    </tbody>
                </table>
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