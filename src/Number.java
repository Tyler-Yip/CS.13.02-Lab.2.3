public class Number
{
    private int number;

    public Number(int number)
    {
        this.number = number;
    }

    public int getDenary()
    {
        return this.number;
    }

    public void setDenary(int number)
    {
        this.number = number;
    }

    public String getSignedBinary()
    {
        if (this.number >= 0)
        {
            return "0" + convertToBinary(this.number);
        }
        else
        {
            return "1" + convertToBinary((~(-this.number) & 0x7F) + 1);
        }
    }

    public String getHexadecimal()
    {
        if (this.number >= 0)
        {
            return convertToHexadecimal(this.number);
        }
        else
        {
            return convertToHexadecimal((~(-this.number) & 0xFF) + 1);
        }
    }

    public void negate()
    {
        this.number = -this.number;
    }

    @Override
    public String toString()
    {
        return "Number{" + "denary=" + number + " binary=" + getSignedBinary() + " hexadecimal=" + getHexadecimal() + "}";
    }

    private String convertToBinary(int number)
    {
        StringBuilder binary = new StringBuilder();
        while (number > 0)
        {
            binary.insert(0, (number % 2));
            number /= 2;
        }
        while (binary.length() < 7)
            binary.insert(0, "0");
        return binary.toString();
    }

    private String convertToHexadecimal(int number)
    {
        StringBuilder hex = new StringBuilder();
        while (number > 0)
        {
            int remainder = number % 16;

            if (remainder < 10)
            {
                hex.insert(0, remainder);
            }
            else
            {
                hex.insert(0, (char) (remainder - 10 + 'A'));
            }

            number /= 16;
        }
        return hex.toString();
    }
}