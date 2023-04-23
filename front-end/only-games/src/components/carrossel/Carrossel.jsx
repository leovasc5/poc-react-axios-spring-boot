import styles from "../css/carrossel/Carrossel.module.css";
import CardJogo from "./../card-box/CardJogo";
import CardEmpresa from "./../card-box/CardEmpresa";
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Carrossel() {
    const [jogos, setJogos] = useState([]);
    const [empresas, setEmpresas] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/jogos')
          .then(response => {
            setJogos(response.data);
          })
          .catch(error => {
            console.log(error);
          });
      }, []);

      useEffect(() => {
        axios.get('http://localhost:8080/empresas')
          .then(response => {
            setEmpresas(response.data);
          })
          .catch(error => {
            console.log(error);
          });
      }, []);


  return (
    <div>
        <h1 className={styles.titulo}>Jogos da Semana</h1>
        <div className={styles.carouselContainer}>
            <div className={styles.carouselWrapper}>
                {
                    jogos.map((jogo) => {
                        return <CardJogo 
                            key = {jogo.id}
                            id = {jogo.id}
                            nome = {jogo.nome}
                            empresa = {jogo.nomeEmpresa}
                            dataLancamento = {jogo.dataLancamento}
                            custo = {jogo.custo}
                            faturamento = {jogo.faturamento}
                            downloads = {jogo.downloads}
                            urlImagem = {jogo.urlImagem}
                        />
                    })
                }
            </div>
        </div>

        <h1 className={styles.titulo}>Empresas da Semana</h1>
        <div className={styles.carouselContainer}>
            <div className={styles.carouselWrapper}>
                {
                    empresas.map((empresa) => {
                        return <CardEmpresa 
                            key = {empresa.id}
                            id = {empresa.id}
                            nome = {empresa.nome}
                            enderecoSede = {empresa.enderecoSede}
                            urlImagem = {empresa.urlImagem}
                        />
                    })
                }
            </div>
        </div>
    </div>
  );
}

export default Carrossel;