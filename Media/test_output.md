Comparing Classifications
=========================

Testing Walking classifier using data from records that matched pattern:

`recorded_records.*phone.*walking_right-back`

Using 4 features for specific classifications:
- Standard Deviation Accelerometer
- Variance Accelerometer
- Mean Absolute Difference Accelerometer
- Mean Accelerometer

Training for Thomas Kellermeier
-------------------------------

Testing against data from **Thomas Kellermeier**

210 classifications calculated, final result is **90%**


| **Training ratio** |     5% |    10% |    15% |    20% |     25% |     50% |     75% |     100% |
| ------------------ | ------:| ------:| ------:| ------:| -------:| -------:| -------:| --------:|
| **Classification** |    54% |    72% |    69% |    74% | **85%** | **84%** | **91%** |  **90%** |
| **Delta to final** |   -36% |   -19% |   -21% |   -16% |     -5% |     -7% |      0% | :unlock: |

Testing against data from **Franziska Eder**

124 classifications calculated, final result is **14%**


| **Training ratio** |     5% |    10% |    15% |    20% |    25% |    50% |    75% |   100% |
| ------------------ | ------:| ------:| ------:| ------:| ------:| ------:| ------:| ------:|
| **Classification** |     6% |    13% |    11% |    12% |    15% |    16% |    14% |    14% |
| **Delta to final** |    -9% |    -2% |    -3% |    -2% |     1% |     2% |     0% | :lock: |

Testing against data from **Stephan Schultz**

108 classifications calculated, final result is **12%**


| **Training ratio** |     5% |    10% |    15% |    20% |    25% |    50% |    75% |   100% |
| ------------------ | ------:| ------:| ------:| ------:| ------:| ------:| ------:| ------:|
| **Classification** |     2% |    17% |    11% |    12% |    13% |    12% |    12% |    12% |
| **Delta to final** |    -9% |     5% |    -1% |     0% |     1% |     1% |     0% | :lock: |


Training for Franziska Eder
---------------------------

Testing against data from **Thomas Kellermeier**

210 classifications calculated, final result is **80%**

:exclamation: Classification is higher than expected, this would be a **false positive**

| **Training ratio** |     5% |    10% |    15% |    20% |    25% |    50% |    75% |     100% |
| ------------------ | ------:| ------:| ------:| ------:| ------:| ------:| ------:| --------:|
| **Classification** |     9% |    38% |    26% |    64% |    63% |    64% |    57% |  **80%** |
| **Delta to final** |   -71% |   -42% |   -54% |   -17% |   -17% |   -16% |   -23% | :unlock: |

Testing against data from **Franziska Eder**

124 classifications calculated, final result is **85%**


| **Training ratio** |     5% |    10% |    15% |    20% |     25% |     50% |     75% |     100% |
| ------------------ | ------:| ------:| ------:| ------:| -------:| -------:| -------:| --------:|
| **Classification** |    46% |    49% |    45% |    65% | **75%** | **79%** | **81%** |  **85%** |
| **Delta to final** |   -39% |   -36% |   -40% |   -20% |    -10% |     -6% |     -4% | :unlock: |

Testing against data from **Stephan Schultz**

108 classifications calculated, final result is **53%**


| **Training ratio** |     5% |    10% |    15% |    20% |    25% |    50% |    75% |   100% |
| ------------------ | ------:| ------:| ------:| ------:| ------:| ------:| ------:| ------:|
| **Classification** |    22% |    20% |    16% |    37% |    45% |    52% |    39% |    53% |
| **Delta to final** |   -31% |   -33% |   -37% |   -15% |    -8% |    -1% |   -13% | :lock: |


Training for Stephan Schultz
----------------------------

Testing against data from **Thomas Kellermeier**

210 classifications calculated, final result is **42%**


| **Training ratio** |      5% |    10% |    15% |    20% |    25% |    50% |    75% |   100% |
| ------------------ | -------:| ------:| ------:| ------:| ------:| ------:| ------:| ------:|
| **Classification** | **75%** |    69% |    64% |    54% |    53% |    61% |    43% |    42% |
| **Delta to final** |     33% |    26% |    22% |    11% |    11% |    19% |     0% | :lock: |

Testing against data from **Franziska Eder**

124 classifications calculated, final result is **47%**


| **Training ratio** |     5% |    10% |    15% |    20% |    25% |    50% |    75% |   100% |
| ------------------ | ------:| ------:| ------:| ------:| ------:| ------:| ------:| ------:|
| **Classification** |    73% |    36% |    26% |    23% |    24% |    37% |    36% |    47% |
| **Delta to final** |    26% |   -11% |   -21% |   -24% |   -23% |   -10% |   -11% | :lock: |

Testing against data from **Stephan Schultz**

108 classifications calculated, final result is **86%**


| **Training ratio** |      5% |     10% |     15% |     20% |     25% |     50% |     75% |     100% |
| ------------------ | -------:| -------:| -------:| -------:| -------:| -------:| -------:| --------:|
| **Classification** | **98%** | **80%** | **82%** | **78%** | **80%** | **85%** | **84%** |  **86%** |
| **Delta to final** |     12% |     -6% |     -4% |     -8% |     -6% |     -1% |     -2% | :unlock: |
