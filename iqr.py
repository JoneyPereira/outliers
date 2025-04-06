import pandas as pd
import numpy as np

# Criando um dataset de exemplo
dados = pd.Series([10, 12, 12, 13, 12, 11, 10, 13, 100])  # 100 é o outlier

# Calculando Q1, Q3 e IQR
Q1 = dados.quantile(0.25)
Q3 = dados.quantile(0.75)
IQR = Q3 - Q1

# Definindo os limites
limite_inferior = Q1 - 1.5 * IQR
limite_superior = Q3 + 1.5 * IQR

# Filtrando outliers
outliers = dados[(dados < limite_inferior) | (dados > limite_superior)]

print("Outliers encontrados:")
print(outliers)
