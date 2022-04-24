import Categories from './components/Categories/Categories';
import Logo_ESIEA from './Logo_ESIEA.png'
import './App.css';

function App() {
  return (
    <>
      <div className="header">
        <h1>Delta Blog</h1>
        <img src={Logo_ESIEA} className="App-logoESIEA" alt="logoESIEA" />
      </div>

      <div className="App">
        <Categories />
      </div>

      <div className="footer">
        <h1>Créé par Samuel Texier</h1>
      </div>
    </>
  );
}

export default App;