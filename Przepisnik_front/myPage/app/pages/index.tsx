import { BlitzPage } from "blitz"
import { useState } from "react"
/*
 * This file is just for a pleasant getting started page for your new app.
 * You can delete everything in here and start from scratch if you like.
 */

const Home: BlitzPage = () => {
  const [opis, setOpis] = useState(String)
  const [sklad, setSklad] = useState(String)
  const [Lista, setLista] = useState([] as any)

  GenerujListe()

  function GenerujListe() {
    console.log(process.env)
    if(process.env.BACK_URL === undefined){
      return 1
    }
    else{
    if (Lista.length > 0) {
      return 1
    } else {
      try{
        fetch("http://" + process.env.BACK_URL as any)
          .then((res) => res.json())
          .then((items) =>
            items.map((i, idx) => {
              return (
                <li key={Math.random()} onClick={() => Kliknij(idx + 1)}>
                  {i}
                </li>
              )
            })
          )
          .then((x) => setLista(x))
        }catch{
        console.log(Error)
      }
    }}
  }

  function Kliknij(idx) {
    fetch("http://" + process.env.LISTA_URL as any + idx)
      .then((res) => res.text())
      .then((d) => setSklad(d)
      )
    fetch("http://" + process.env.OPIS_URL as any + idx)
      .then((res) => res.text())
      .then((d) => setOpis(d)
      )
  }
  return (
    <div className="container">
      <header>
        <h1>Alicja Szada - Przepiśnik</h1>
      </header>
      <div id="przepisy">
        <div id="listaPrzepisow">
          <h3>Lista przepisów</h3>
          {Lista}
        </div>
        <div id="listaSkladnikow">
          <h3>Lista składników</h3>
          <pre>{sklad}</pre>
        </div>
        <div id="opisPrzepisu">
          <h3>Opis przygotowania</h3>
          <pre>{opis}</pre>
        </div>
      </div>
    </div>
  )
}

Home.suppressFirstRenderFlicker = true

export default Home
