import React from 'react';
import styles from "../components/css/page/Reset.module.css";
import Header from '../components/page/Header';
import Carrossel from '../components/carrossel/Carrossel';

function IndexPage() {
  return (
    <div style={styles}>
      <Header linkJogos={"jogos/"} linkEmpresas={"jogos/"} />
      <Carrossel />
    </div>
  );
}

export default IndexPage;