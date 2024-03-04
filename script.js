let a = []
const fieldSize = 6

function checkName()
{
    const form = document.querySelector('form');

    const messageFromText = form.querySelector('#Name');
    const value = messageFromText.value;
    const error = document.getElementById('incorrectName');

    if(!value.trim())
    {
        error.style.display = 'block';
        
        a[0] = 0; 
        return false;
    }
    else
    {
        error.style.display = 'none'
        a[0] = 1;
        return true;
    }
}

function checkUserName()
{
    const form = document.querySelector('form');

    const messageFromText = form.querySelector('#userName');
    const value = messageFromText.value;
    const error = document.getElementById('incorrectUserName');

    if(!value.trim())
    {

        error.style.display = 'block';
        a[1] = 0; 

        return false;
    }
    else
    {
        error.style.display = 'none'
        a[1] = 1; 

        return true;
    }
}

function checkPasswordsMatch()
{
    const form = document.querySelector('form');

    const messageFromText = form.querySelector('#password');
    const messageFromText2 = form.querySelector('#repeatPassword');

    const value = messageFromText.value;
    const value2 = messageFromText2.value;


    const error = document.getElementById('passwordTooShort');
    const error2 = document.getElementById('incorrectPassword');
    
    if(!value.trim())
    {

        error.style.display = 'block';
        a[2] = 0; 

        return false;
    }

    error.style.display = 'none';
    
    if(!(value === value2))
    {

        error2.style.display = 'block';
        a[2] = 0; 

        return false;
    }
    
    error2.style.display = 'none';
    a[2] = 1; 

    return true;

}

function checkEmail()
{
    const form = document.querySelector('form');

    const messageFromText = form.querySelector('#email');
    const value = messageFromText.value;
    const error = document.getElementById('emailEmpty');

    if(!value.trim())
    {

        error.style.display = 'block';
        a[3] = 0; 

        return false;
    }

    error.style.display = 'none';
    


    var pattern = /([A-Za-z]\w+@)\w+\.\w*/;
    
    const error2 = document.getElementById('emailNotGood');
    if(!pattern.test(value))
    {

        error2.style.display = 'block';
        a[3] = 0; 

        return false;
    }

    error2.style.display = 'none';
    a[3] = 1; 

    return true;
}

function checkGender()
{
    const form = document.querySelector('form');

    const messageFromText = form.querySelector('#Male');
    const messageFromText2 = form.querySelector('#Female');

    const value = messageFromText.value;
    const value2 = messageFromText2.value;

    if(!value.trim() && !value2.trim())
    {
        const error = document.getElementById('incorectGender');

        error.style.display = 'block';
        a[4] = 0; 

        return false;
    }

    error.style.display = 'none';
    a[4] = 1; 

    return true;
}

function checkTelephone()
{
    const form = document.querySelector('form');

    const messageFromText = form.querySelector('#telephone');
    const value = messageFromText.value;
    const error2 = document.getElementById('emptyTelephone');

    if(!value.trim())
    {

        error2.style.display = 'block';
        a[5] = 0; 

        return false;
    }

    error2.style.display = 'none';

    const error = document.getElementById('invalidChars');
    if(value.length > 10)
    {
        if(value.charAt(0) !== '+' || value.length > 14)
        {

            error.style.display = 'block';
            a[5] = 0; 

            return false;
        }
        else
        {
            for(let i = 1; i < value.length; ++i)
            {
                if(!Number.isNaN(value.charAt(0)))
                {
                    const error = document.getElementById('invalidChars');

                    error.style.display = 'block';
                    a[5] = 0; 

                    return false;
                }
            }
        }
    }
    else
    {
        const error = document.getElementById('invalidChars');
        
        for(let i = 0; i < value.length; ++i)
        {
            if(!Number.isNaN(value.charAt(0)))
            {

                error.style.display = 'block';
                a[5] = 0; 

                return false;
            }
        }

    }
    
    a[5] = 1; 

    error.style.display = 'none';

    return true;
}

function validate()
{

    for(let i = 0; i < fieldSize; ++i)
    {
        if(a[i] == 0)
            return false;
    }   

    return true;
}