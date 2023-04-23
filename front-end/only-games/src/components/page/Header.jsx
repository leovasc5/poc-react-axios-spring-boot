import React from "react";
import styles from "./../css/page/Header.module.css";

function Header(props) {
  return (
    <header className={styles.header}>
      <div className={styles.logo}>
        <img src="https://cdn-icons-png.flaticon.com/512/1451/1451303.png" alt="Logo" />
      </div>
      <nav className={styles.nav}>
        <ul>
          <li><a href={props.linkJogos}>Jogos</a></li>
          <li><a href={props.linkEmpresas}>Empresas</a></li>
        </ul>
      </nav>
    </header>
  );
}

export default Header;
