<div class="nav-bar">
  <nav>
    <!-- Display logo -->
    <div class="logo">LOGO</div>

    <!-- Display links -->
    <ul class="nav-links">
      <li>
        <a href="${pageContext.request.contextPath}/home">
          Home
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/patients/list">
          Patients
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/doctors/list">
          Doctor
        </a>
      </li>
      <li><a href="#">Procedures</a></li>
    </ul>

    <!-- Display burger icon -->
    <div class="burger">
      <div class="line1"></div>
      <div class="line2"></div>
      <div class="line3"></div>
    </div>
  </nav>
  <script src="${pageContext.request.contextPath}/resources/scripts/navSlide.js"></script>
</div>
