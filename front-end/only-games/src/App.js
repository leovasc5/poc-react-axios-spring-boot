import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import React from "react";
import IndexPage from './pages/IndexPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<IndexPage />} />
        <Route exact path="/jogos" element={<IndexPage />} />
        <Route exact path="/empresas" element={<IndexPage />} />
      </Routes>
    </Router>
  );
}

export default App;
