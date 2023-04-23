import React from "react";
import styles from  "../css/card-box/CardEmpresa.module.css";

function CardEmpresa(props){
    return (    
        <div className={styles.carouselItem} onClick={() => { window.location.href = `/empresas/${props.id}`; } }>
            <div className={styles.empresaImage}>
                <img src={props.urlImagem} alt={props.nome} />
            </div>
            <div className={styles.gameInfo}>
                <h3 className={styles.empresaName}>{props.nome}</h3>
                <p className={styles.empresaEndereco}> {props.enderecoSede}</p>
            </div>
        </div>
    );
}

export default CardEmpresa;