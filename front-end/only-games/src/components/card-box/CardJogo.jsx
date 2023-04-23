import React from "react";
import styles from  "../css/card-box/CardJogo.module.css";

function CardJogo(props){
    return (    
        <div className={styles.carouselItem} onClick={() => { window.location.href = `/jogos/${props.id}`; } }>
            <div className={styles.gameImage}>
                <img src={props.urlImagem} alt={props.nome} />
            </div>
            <div className={styles.gameInfo}>
                <h3 className={styles.gameName}>{props.nome}</h3>
                <p className={styles.gameCompany}> {props.empresa}</p>
                <p className={styles.gameRealeaseDate}>{props.dataLancamento}</p>
                <p className={styles.gameCost}>Custo: {props.custo}</p>
                <p className={styles.gameRevenue}>Faturamento: {props.faturamento}</p>
                <p className={styles.gameDownloads}>{props.downloads} downloads</p>
            </div>
        </div>
    );
}

export default CardJogo;