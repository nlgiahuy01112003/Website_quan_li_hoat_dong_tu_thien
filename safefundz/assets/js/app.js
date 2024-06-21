/* ---------------------------> 
    NavBar Fix
<--------------------------- */
$(document).ready(function () {
  let lastScrollPosition = $(window).scrollTop();

  $(window).scroll(function () {
    let currentScrollPosition = $(window).scrollTop();
    let menu = $(".menu__scroll");

    if (currentScrollPosition > lastScrollPosition) {
      menu.css("transform", "translateY(-100%)");
    } else {
      menu.css("transform", "translateY(0)");
    }

    if (currentScrollPosition === 0) {
      menu.css("box-shadow", "none");
      menu
        .addClass("global__transparent position-relative")
        .removeClass("position-fixed");
    } else {
      menu.addClass("position-fixed").removeClass("global__transparent");
      menu.css("box-shadow", "0 3px 12px 0 rgba(0, 0, 0, 0.1)");
    }

    lastScrollPosition = currentScrollPosition;
  });
});

/* ---------------------------> 
    AOS
<--------------------------- */
AOS.init();

/* ---------------------------> 
    Go-Up
<--------------------------- */
$(document).ready(function () {
  $(window).scroll(function () {
    if ($(this).scrollTop() > 100) {
      $("#topBtn").fadeIn();
    } else {
      $("#topBtn").fadeOut();
    }
  });

  $("#topBtn").click(function () {
    $("html ,body").animate({ scrollTop: 0 }, 800);
  });
});

/* ---------------------------> 
  Form Validation
<--------------------------- */
$(document).ready(function () {
  $("form").submit(function (e) {
    e.preventDefault();
  });

  const validateInput = (input, validErr, validErrReq, regex) => {
    const str = input.val();

    if (regex.test(str)) {
      validErr.removeClass("sign__text-show");
      validErrReq.removeClass("sign__text-show");
    } else if (str === "") {
      validErrReq.addClass("sign__text-show");
      validErr.removeClass("sign__text-show");
    } else {
      validErr.addClass("sign__text-show");
      validErrReq.removeClass("sign__text-show");
    }
  };

  //---> For name
  $("#nameInp").blur(function () {
    const regx = /^[a-zA-Z]([0-9a-zA-Z]){2,10}$/;
    validateInput(
      $(this),
      $(".sign__text-name"),
      $(".sign__text-name--required"),
      regx
    );
  });
  
  //---> For Last-Name
  $("#lastname").blur(function () {
    const regx = /^[a-zA-Z]([0-9a-zA-Z]){2,10}$/;
    validateInput(
      $(this),
      $(".sign__text-nam"),
      $(".sign__text-lastname--required"),
      regx
    );
  });

  //---> For Email
  $("#emailInp").blur(function () {
    const regx = /^([_\-\.0-9a-zA-Z]+)@([_\-\.0-9a-zA-Z]+)\.([a-zA-Z]){2,7}$/;
    validateInput(
      $(this),
      $(".sign__text-email"),
      $(".sign__text-email--required"),
      regx
    );
  });

  //---> For Password
  $("#passwordInp").blur(function () {
    const regx = /^[a-zA-Z]([0-9a-zA-Z]){2,5}$/;
    validateInput(
      $(this),
      $(".sign__text-pass"),
      $(".sign__text-pass--required"),
      regx
    );
  });

  //---> For Phone-Number
  $("#phnInp").blur(function () {
    const regx = /^0\d{10}$/;
    validateInput(
      $(this),
      $(".sign__text-phn"),
      $(".sign__text-phn--required"),
      regx
    );
  });

  //---> For Date_of_Birth
  $("#date").blur(function () {
    const regx = /[\s\S]/;
    validateInput(
      $(this),
      $(".sign__text-ph"),
      $(".sign__text-date--required"),
      regx
    );
  });

  //---> For Occupation
  $("#occupation").blur(function () {
    const regx = /[\s\S]/;
    validateInput(
      $(this),
      $(".sign__text-ph"),
      $(".sign__text-occu--required"),
      regx
    );
  });

  //---> For Message
  $("#comment").blur(function () {
    const regx = /[\s\S]/;
    validateInput(
      $(this),
      $(".sign__text-ph"),
      $(".sign__text-msg--required"),
      regx
    );
  });
});

/* ---------------------------> 
   Sign_Slider
<--------------------------- */
$(document).ready(function () {
  $(".sign__slider").slick({
    centerMode: false,
    arrows: true,
    slidesToShow: 1,
    fade: true,
    autoplay: true,
    prevArrow:
      '<div class="sign__card-icons sign__card-icons--left"><i class="fa-solid fa-arrow-left global__arrow-default"></i></div>',
    nextArrow:
      '<div class="sign__card-icons sign__card-icons--right"><i class="fa-solid fa-arrow-right global__arrow-default"></i></div>',
  });
});

/* ---------------------------> 
    Blog_Slider
<--------------------------- */
$(document).ready(function () {
  $(".blog__body-slider").slick({
    centerMode: false,
    arrows: true,
    slidesToShow: 3,
    prevArrow:
      '<div class="global__arrow blog__body-arrow--left"><i class="fa-solid fa-arrow-left global__arrow-default"></i></div>',
    nextArrow:
      '<div class="global__arrow justify-content-start blog__body-arrow--right"><i class="fa-solid fa-arrow-right global__arrow-default"></i></div>',
    responsive: [
      {
        breakpoint: 991,
        settings: {
          arrows: true,
          dots: false,
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 767,
        settings: {
          arrows: false,
          dots: true,
          slidesToShow: 1,
        },
      },
    ],
  });
});

/* ---------------------------> 
    Cases_Slider's
<--------------------------- */
$(document).ready(function () {
  $(".cases__slider").slick({
    centerMode: false,
    arrows: true,
    slidesToShow: 3,
    draggable: true,
    prevArrow:
      '<div class="global__arrow global__arrow-left justify-content-end"><i class="fa-solid fa-arrow-left global__arrow-default"></i></div>',
    nextArrow:
      '<div class="global__arrow global__arrow-right justify-content-start"><i class="fa-solid fa-arrow-right global__arrow-default"></i></div>',
    responsive: [
      {
        breakpoint: 1199,
        settings: {
          arrows: true,
          dots: false,
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 767,
        settings: {
          arrows: true,
          dots: false,
          slidesToShow: 1,
        },
      },
    ],
  });
});
$(document).ready(function () {
  $(".cases__slider2").slick({
    arrows: true,
    rows: 2,
    slidesToShow: 3,
    prevArrow:
      '<div class="global__arrow global__arrow-left justify-content-end m-0"><i class="fa-solid fa-arrow-left global__arrow-default"></i></div>',
    nextArrow:
      '<div class="global__arrow global__arrow-right justify-content-start m-0"><i class="fa-solid fa-arrow-right global__arrow-default"></i></div>',
    responsive: [
      {
        breakpoint: 1199,
        settings: {
          arrows: true,
          dots: false,
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 767,
        settings: {
          arrows: true,
          dots: false,
          slidesToShow: 1,
        },
      },
    ],
  });
});
$(document).ready(function () {
  $(".cases__slider3-slider").slick({
    centerMode: false,
    arrows: true,
    slidesToShow: 3,
    prevArrow:
      '<div class="global__arrow cases__slider3-arrow--left"><i class="fa-solid fa-arrow-left global__arrow-default"></i></div>',
    nextArrow:
      '<div class="global__arrow justify-content-start cases__slider3-arrow--right"><i class="fa-solid fa-arrow-right global__arrow-default"></i></div>',
    responsive: [
      {
        breakpoint: 1399,
        settings: {
          arrows: true,
          dots: false,
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 1199,
        settings: {
          arrows: false,
          dots: true,
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 767,
        settings: {
          arrows: false,
          dots: true,
          slidesToShow: 1,
        },
      },
    ],
  });
});

/* ---------------------------> 
    Testimonial__Slider's
<--------------------------- */
$(document).ready(function () {
  $(".testimonial__body-slider").slick({
    centerMode: false,
    arrows: true,
    slidesToShow: 2,
    prevArrow:
      '<div class="global__arrow testimonial__arrow-left"><i class="fa-solid fa-arrow-left global__arrow-default"></i></div>',
    nextArrow:
      '<div class="global__arrow justify-content-start testimonial__arrow-right"><i class="fa-solid fa-arrow-right global__arrow-default"></i></div>',
    responsive: [
      {
        breakpoint: 1199,
        settings: {
          arrows: true,
          dots: false,
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 767,
        settings: {
          arrows: false,
          dots: true,
          slidesToShow: 1,
        },
      },
    ],
  });
});
$(document).ready(function () {
  $(".testimonial__body-slider2").slick({
    centerMode: true,
    arrows: true,
    slidesToShow: 3,
    prevArrow:
      '<div class="global__arrow global__arrow-left justify-content-end"><i class="fa-solid fa-arrow-left global__arrow-default"></i></div>',
    nextArrow:
      '<div class="global__arrow global__arrow-right justify-content-start slick-arrow"><i class="fa-solid fa-arrow-right global__arrow-default"></i></div>',
    responsive: [
      {
        breakpoint: 1199,
        settings: {
          arrows: true,
          dots: false,
          centerMode: true,
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 767,
        settings: {
          arrows: false,
          dots: true,
          centerMode: false,
          slidesToShow: 1,
        },
      },
    ],
  });
});
$(document).ready(function () {
  $(".testimonial__body-slider3").slick({
    centerMode: false,
    arrows: true,
    slidesToShow: 3,
    prevArrow:
      '<div class="global__arrow global__arrow-left justify-content-end"><i class="fa-solid fa-arrow-left global__arrow-default"></i></div>',
    nextArrow:
      '<div class="global__arrow global__arrow-right justify-content-start slick-arrow"><i class="fa-solid fa-arrow-right global__arrow-default"></i></div>',
    responsive: [
      {
        breakpoint: 1199,
        settings: {
          arrows: true,
          dots: false,
          centerMode: true,
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 767,
        settings: {
          arrows: false,
          dots: true,
          centerMode: false,
          slidesToShow: 1,
        },
      },
    ],
  });
});

/* ---------------------------> 
    Number Counter
<--------------------------- */
$(document).ready(function ($) {
  $(".num__counter").counterUp({
    delay: 10,
    time: 2000,
  });
});

/* ---------------------------> 
    Hero_Swiper_Slide
<--------------------------- */
$(document).ready(function () {
  if ($(".swiper").length > 0) {
    new Swiper(".mySwiper", {
      slidesPerView: "auto",
      spaceBetween: 30,
      loop: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
    });
  }
});

/* ---------------------------> 
    VenoBox
<--------------------------- */
$(document).ready(function () {
  new VenoBox({
    selector: ".video__card",
  });
});

/* ---------------------------> 
    VenoBox for Gallery
<--------------------------- */
$(document).ready(function () {
  new VenoBox({
    selector: ".gallery__body-layer",
    numeration: true,
    infinigall: true,
    spinner: "rotating-plane",
  });
});
