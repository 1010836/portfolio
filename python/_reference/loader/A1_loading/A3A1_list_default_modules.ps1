# Color and formatting functions
function Write-Option {
    param([string]$key, [string]$description)
    Write-Host " [$key] " -ForegroundColor Green -NoNewline
    Write-Host $description -ForegroundColor White
}

function Write-Info {
    param([string]$text)
    Write-Host $text -ForegroundColor Cyan
}

function Write-Error {
    param([string]$text)
    Write-Host $text -ForegroundColor Red
}

function Write-Success {
    param([string]$text)
    Write-Host $text -ForegroundColor Green
}

# Main script
try {
    # Get script directory
    $scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
    $pythonFile = Join-Path $scriptDir "A3A2_list_default_modules.py"

    # Check if Python file exists
    if (-not (Test-Path $pythonFile)) {
        Write-Error "Error: Python file not found at: $pythonFile"
        exit 1
    }

    Write-Info "Choose execution mode:"
    Write-Host ""
    Write-Option "S" "Simple mode (python -S) - Minimal default modules"
    Write-Option "N" "Normal mode (python) - Standard default modules"
    Write-Host ""
    
    # Get user choice
    do {
        $choice = Read-Host "Select option [S/N]"
        $choice = $choice.ToUpper()
    } while ($choice -notin @("S", "N"))

    # Determine Python command
    $pythonCmd = if ($choice -eq "S") { "python -S" } else { "python" }
    $modeText = if ($choice -eq "S") { "Simple (-S)" } else { "Normal" }

    # Display execution info
    Write-Host ""
    Write-Info "Command: $pythonCmd `"$pythonFile`""
    Write-Host ""

    # Execute Python script
    $fullCommand = "$pythonCmd `"$pythonFile`""
    Invoke-Expression $fullCommand

} catch {
    Write-Host ""
    Write-Error "An error occurred: $($_.Exception.Message)"
    exit 1
}
