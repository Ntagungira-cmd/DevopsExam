import React, {Component} from 'react';
import './Calculator.css';


class Calculator extends Component {

    constructor(props) {
        super(props);
        this.state = {
            currentValue: 0,
            currentOperand: null,
            firstValue: null,
            operandClicked: false
        };

        this.numberButtonClicked = this.numberButtonClicked.bind(this);
        this.operandButtonClicked = this.operandButtonClicked.bind(this);
    }

    numberButtonClicked(event) {
        const newValue = parseInt(event.target.value, 10);

        if (this.state.operandClicked) {
            this.setState({
                currentValue: newValue,
                operandClicked: false
            });
        }
        else if (this.state.currentValue === 0) {
            this.setState({
                currentValue: newValue
            });
        }
        else {
            this.setState({
                currentValue: this.state.currentValue + event.target.value
            });
        }
    }

    setCalculationState(currentValue) {
        this.setState({
            currentValue: currentValue,
            firstValue: null,
            currentOperand: null,
            operandClicked: true
        });
    }

    makeCalculation() {

        switch (this.state.currentOperand) {
            case '+':
                this.setCalculationState(parseInt(this.state.firstValue, 10) + parseInt(this.state.currentValue, 10));
                break;
            case '-':
                this.setCalculationState(parseInt(this.state.firstValue, 10) - parseInt(this.state.currentValue, 10));
                break;
            case '*':
                this.setCalculationState(parseInt(this.state.firstValue, 10) * parseInt(this.state.currentValue, 10));
                break;
            case '/':
                this.setCalculationState(parseFloat(this.state.firstValue, 10) / parseFloat(this.state.currentValue, 10));
                break;
            default:
                this.setState({
                    currentOperand: null,
                    operandClicked: false
                });
                break;
        }

    }

    setOperandState(currentOperand) {
        this.setState({
            currentOperand: currentOperand,
            firstValue: this.state.currentValue,
            operandClicked: true
        });
    }

    operandButtonClicked(event) {

        switch (event.target.value) {
            case '+':
                this.setOperandState('+');
                break;
            case '-':
                this.setOperandState('-');
                break;
            case '*':
                this.setOperandState('*');
                break;
            case '/':
                this.setOperandState('/');
                break;
            case 'C':
                this.setState({
                    currentOperand: null,
                    firstValue: null,
                    operandClicked: false,
                    currentValue: 0
                });
                break;
            case '=':
                this.makeCalculation();
                break;
            default:
                break;
        }

    }

    render() {
        return (
            <div className='calculator-container'>
                <h1>CALCULATOR</h1>
                <div className='input-container'>
                    <div></div>
                    <div className='input-value'>
                        <input type='number' disabled={true} value={this.state.currentValue}  data-cy="result"/>
                    </div>
                    <div></div>
                </div>
                <div className='numbers-container'>
                    <div className='numbers'>
                        <button value={'C'} className='clear' onClick={this.operandButtonClicked} data-cy="buttonClear">C</button>
                        <button value={'='} className='equals' onClick={this.operandButtonClicked} data-cy="buttonEquals">=</button>
                    </div>
                    <div className='operands'>
                        <button value={'+'} className='sum' onClick={this.operandButtonClicked} data-cy="buttonSum">+</button>
                        <button value={'-'} className='subtract' onClick={this.operandButtonClicked} data-cy="buttonSubtract">-</button>
                        <button value={'*'} className='multiply' onClick={this.operandButtonClicked} data-cy="buttonMultiply">*</button>
                        <button value={'/'} className='divide' onClick={this.operandButtonClicked} data-cy="buttonDivide">/</button>
                    </div>
                </div>
            </div>
        );
    }

}

export default Calculator;