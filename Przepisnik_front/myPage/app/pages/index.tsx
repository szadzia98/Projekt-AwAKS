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
    if (Lista.length > 0) {
      return 1
    } else {
      try{
        fetch("http://przepisnik-back-labproj22.apps.ocp.lab.cloudpak.site")
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
    }
  }

  function Kliknij(idx) {
    fetch("http://przepisnik-back-labproj22.apps.ocp.lab.cloudpak.site/" + idx)
      .then((res) => res.json())
      .then((d) => {
      setSklad(d[0]);
    setOpis(d[1])
    }
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
