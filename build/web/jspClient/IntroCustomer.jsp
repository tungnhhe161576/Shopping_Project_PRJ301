<%-- 
    Document   : HeaderForCustomer
    Created on : Mar 5, 2023, 8:50:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            img {
                vertical-align: middle;
            }

            /* Position the image container (needed to position the left and right arrows) */
            .container {
                position: relative;
            }

            /* Hide the images by default */
            .mySlides {
                display: none;
            }

            /* Add a pointer when hovering over the thumbnail images */
            .cursor {
                cursor: pointer;
            }

            /* Next & previous buttons */
            .prev,
            .next {
                cursor: pointer;
                position: absolute;
                top: 40%;
                width: auto;
                padding: 16px;
                margin-top: -50px;
                color: white;
                font-weight: bold;
                font-size: 20px;
                border-radius: 0 3px 3px 0;
                user-select: none;
                -webkit-user-select: none;
            }

            /* Position the "next button" to the right */
            .next {
                right: 0;
                border-radius: 3px 0 0 3px;
            }

            /* On hover, add a black background color with a little bit see-through */
            .prev:hover,
            .next:hover {
                background-color: rgba(0, 0, 0, 0.8);
            }

            /* Number text (1/3 etc) */
            .numbertext {
                color: #f2f2f2;
                font-size: 12px;
                padding: 8px 12px;
                position: absolute;
                top: 0;
            }

            /* Container for image text */
            .caption-container {
                text-align: center;
                background-color: #222;
                padding: 2px 16px;
                color: white;
            }

            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Six columns side by side */
            .column {
                float: left;
                width: 16.66%;
            }

            /* Add a transparency effect for thumnbail images */
            .demo {
                opacity: 0.6;
            }

            .active,
            .demo:hover {
                opacity: 1;
            }

            .header-img{
                background-color: #f1f1f1; 
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
                <div class="mySlides">
                    <div class="numbertext">1 / 6</div>
                    <img src="https://img6.thuthuatphanmem.vn/uploads/2022/04/15/anh-nen-tuong-yasuo-4k_040627692.jpg" style="width:100%">
                </div>

                <div class="mySlides">
                    <div class="numbertext">2 / 6</div>
                    <img src="https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/02/hinh-nen-yasuo-4k-cho-pc.jpg?ssl=1" style="width:100%">
                </div>

                <div class="mySlides">
                    <div class="numbertext">3 / 6</div>
                    <img src="https://img6.thuthuatphanmem.vn/uploads/2022/04/15/anh-nen-tuong-yasuo-4k_040627692.jpg" style="width:100%">
                </div>

                <div class="mySlides">
                    <div class="numbertext">4 / 6</div>
                    <img src="https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/02/hinh-nen-yasuo-4k-cho-pc.jpg?ssl=1" style="width:100%">
                </div>

                <div class="mySlides">
                    <div class="numbertext">5 / 6</div>
                    <img src="https://img6.thuthuatphanmem.vn/uploads/2022/04/15/anh-nen-tuong-yasuo-4k_040627692.jpg" style="width:100%">
                </div>

                <div class="mySlides">
                    <div class="numbertext">6 / 6</div>
                    <img src="https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/02/hinh-nen-yasuo-4k-cho-pc.jpg?ssl=1" style="width:100%">
                </div>

                <a class="prev" onclick="plusSlides(-1)">❮</a>
                <a class="next" onclick="plusSlides(1)">❯</a>

                <div class="caption-container">
                    <p id="caption"></p>
                </div>

                <div class="row">
                    <div class="column">
                        <img class="demo cursor" src="https://img6.thuthuatphanmem.vn/uploads/2022/04/15/anh-nen-tuong-yasuo-4k_040627692.jpg" style="width:100%" onclick="currentSlide(1)" alt="Ảnh 1">
                    </div>
                    <div class="column">
                        <img class="demo cursor" src="https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/02/hinh-nen-yasuo-4k-cho-pc.jpg?ssl=1" style="width:100%" onclick="currentSlide(2)" alt="Ảnh 2">
                    </div>
                    <div class="column">
                        <img class="demo cursor" src="https://img6.thuthuatphanmem.vn/uploads/2022/04/15/anh-nen-tuong-yasuo-4k_040627692.jpg" style="width:100%" onclick="currentSlide(3)" alt="Ảnh 3">
                    </div>
                    <div class="column">
                        <img class="demo cursor" src="https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/02/hinh-nen-yasuo-4k-cho-pc.jpg?ssl=1" style="width:100%" onclick="currentSlide(4)" alt="Ảnh 4">
                    </div>
                    <div class="column">
                        <img class="demo cursor" src="https://img6.thuthuatphanmem.vn/uploads/2022/04/15/anh-nen-tuong-yasuo-4k_040627692.jpg" style="width:100%" onclick="currentSlide(5)" alt="Ảnh 5">
                    </div>    
                    <div class="column">
                        <img class="demo cursor" src="https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/02/hinh-nen-yasuo-4k-cho-pc.jpg?ssl=1" style="width:100%" onclick="currentSlide(6)" alt="Ảnh 6">
                    </div>
                </div>
            </div>
            <script>
                let slideIndex = 1;
                showSlides(slideIndex);

                function plusSlides(n) {
                    showSlides(slideIndex += n);
                }

                function currentSlide(n) {
                    showSlides(slideIndex = n);
                }

                function showSlides(n) {
                    let i;
                    let slides = document.getElementsByClassName("mySlides");
                    let dots = document.getElementsByClassName("demo");
                    let captionText = document.getElementById("caption");
                    if (n > slides.length) {
                        slideIndex = 1
                    }
                    if (n < 1) {
                        slideIndex = slides.length
                    }
                    for (i = 0; i < slides.length; i++) {
                        slides[i].style.display = "none";
                    }
                    for (i = 0; i < dots.length; i++) {
                        dots[i].className = dots[i].className.replace(" active", "");
                    }
                    slides[slideIndex - 1].style.display = "block";
                    dots[slideIndex - 1].className += " active";
                    captionText.innerHTML = dots[slideIndex - 1].alt;
                }
            </script>
    </body>
</html>
