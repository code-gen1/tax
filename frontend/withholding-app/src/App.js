import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [productCountry, setProductCountry] = useState('US');
  const [counterpartyCountry, setCounterpartyCountry] = useState('FR');
  const [income, setIncome] = useState('');
  const [result, setResult] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/product/calculateTax', {
        productCountry,
        counterpartyCountryCode: counterpartyCountry,
        income: parseFloat(income)
      });
      setResult(JSON.stringify(response.data));
    } catch (err) {
      setResult('Error: ' + err.message);
    }
  };

  return (
    <div style={{maxWidth:'600px', margin:'2rem auto', fontFamily:'Arial'}}>
      <h2>Withholding Tax Calculator</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Product Base Country:</label>
          <select value={productCountry} onChange={e => setProductCountry(e.target.value)}>
            <option value="US">US</option>
            <option value="OTHER">Other</option>
          </select>
        </div>
        <div>
          <label>Counterparty Country Code:</label>
          <input type="text" value={counterpartyCountry} onChange={e => setCounterpartyCountry(e.target.value)} required/>
        </div>
        <div>
          <label>Income (USD):</label>
          <input type="number" value={income} onChange={e => setIncome(e.target.value)} required/>
        </div>
        <button type="submit">Calculate</button>
      </form>
      <div style={{marginTop:'1rem'}}>
        <strong>Result:</strong>
        <pre>{result}</pre>
      </div>
    </div>
  );
}

export default App;
