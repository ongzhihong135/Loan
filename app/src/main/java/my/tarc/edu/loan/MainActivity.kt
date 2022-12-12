package my.tarc.edu.loan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import my.tarc.edu.loan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{
            val sellingPrice = binding.editTextNumberSellingPrice.text.toString().toInt()
            val downPayment = binding.editTextNumberDownPayment.text.toString().toInt()
            val firstTimeBuyer = binding.checkBoxFirstTime.isChecked

            var legalFees: Float = 0.0f
            var stampDuty: Float = 0.0f

            //Check first time buyer down payment is 10% of the selling price
            if(firstTimeBuyer){
                if(downPayment >= sellingPrice * 0.1){
                    //This is ok

                }else{
                    //This is NOT ok

                }
            }else{
                //none first time buyer

            }
            val myLoan = Loan(legalFees.toString(),stampDuty.toString())
            binding.myLoan = myLoan
        }
        binding.buttonReset.setOnClickListener{
            val myLoan = Loan("" , "")
            //binding.myLoan is define in one data binding
            //myLoan is a local variable
            binding.myLoan = myLoan
        }

        binding.imageViewContactUs.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(uriString: "tel:03456789")
            startActivity(intent)
        }

        binding.imageViewVisit.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(uriString: "https://pbebank.com/.")
            startActivity(intent)
        }


        setContentView(R.layout.activity_main)
    }
}